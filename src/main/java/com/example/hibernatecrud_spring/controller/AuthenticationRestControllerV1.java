package com.example.hibernatecrud_spring.controller;

import com.example.hibernatecrud_spring.model.User;
import com.example.hibernatecrud_spring.repository.UserRepository;
import com.example.hibernatecrud_spring.security.dto.AuthenticationRequestDto;
import com.example.hibernatecrud_spring.security.dto.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.NamingSecurityException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationRestControllerV1 {
    private final AuthenticationManager manager;
    private final UserRepository repository;
    private final JwtTokenProvider tokenProvider;

    public AuthenticationRestControllerV1(AuthenticationManager manager, UserRepository repository, JwtTokenProvider tokenProvider) {
        this.manager = manager;
        this.repository = repository;
        this.tokenProvider = tokenProvider;
    }



    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDto request){
        try {

                manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
            User user = repository.findByUserName(request.getUsername());
            String token = tokenProvider.createToken(request.getUsername(),user.getRole().name());
            Map<Object,Object> response = new HashMap<>();
            response.put("username",request.getUsername());
            response.put("token",token);
            return ResponseEntity.ok(response);
        }catch (AuthenticationException exception){
            return new ResponseEntity<>("Invalid username or password combination", HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping("/logout")
    public void logout(HttpServletRequest req, HttpServletResponse resp){
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(req,resp,null);
    }
}
