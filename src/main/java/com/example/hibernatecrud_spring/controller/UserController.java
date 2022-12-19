package com.example.hibernatecrud_spring.controller;

import com.example.hibernatecrud_spring.model.User;
import com.example.hibernatecrud_spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User find(@PathVariable Integer id) {

        return userService.getOneUser(id);
    }

    @GetMapping()
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        userService.deleteUser(id);
        log.info("User was deleted ");
    }

}
