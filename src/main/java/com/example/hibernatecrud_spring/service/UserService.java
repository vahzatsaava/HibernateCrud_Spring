package com.example.hibernatecrud_spring.service;

import com.example.hibernatecrud_spring.model.User;
import com.example.hibernatecrud_spring.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    public User save(User user) {
        return userRepository.add(user);
    }

    public User update(User user) {
        return userRepository.update(user);
    }

    public User getOneUser(Integer id) {
        User user = userRepository.find(id);
        log.info("In method findByID - user {} successfully found by id {}", user,id);
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.getAll();
        log.info("in getAll {} users found", users.size());
        return users;
    }
    public User findByUserName(String userName){
        User user = userRepository.findByUserName(userName);
        log.info("In method findByUserName - user {} successfully found by name {}", user,userName);
        return user;
    }

    public void deleteUser(Integer id) {
        userRepository.delete(id);
        log.info("in delete user with id {} successfully deleted",id);
    }
}
