package com.example.hibernatecrud_spring.security;

import com.example.hibernatecrud_spring.model.User;
import com.example.hibernatecrud_spring.security.jwt.JwtUser;
import com.example.hibernatecrud_spring.security.jwt.JwtUserFactory;
import com.example.hibernatecrud_spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        if (user == null){
            throw new UsernameNotFoundException("user with username " + username + " not found");
        }
        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("in load by userName - user with userName {} successfully loaded",username);
        return jwtUser;
    }
}
