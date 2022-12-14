package com.example.hibernatecrud_spring.service;

import com.example.hibernatecrud_spring.model.User;
import com.example.hibernatecrud_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return userRepository.find(id);
    }

    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }
}
