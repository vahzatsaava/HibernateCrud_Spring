package com.example.hibernatecrud_spring.controller;

import com.example.hibernatecrud_spring.model.User;
import com.example.hibernatecrud_spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','MODERATOR','ADMIN')")
    public User find(@PathVariable Long id) {
        return userService.getOneUser(id);
    }

    @GetMapping()
    @PreAuthorize("hasAnyRole('MODERATOR','ADMIN')")
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id){
        userService.deleteUser(id);
        log.info("User was deleted ");
    }
    @GetMapping("/name")
    @PreAuthorize("hasAnyRole('USER','MODERATOR','ADMIN')")
    public User getUserByName(@RequestParam String name){
        return userService.findByUserName(name);
    }

}
