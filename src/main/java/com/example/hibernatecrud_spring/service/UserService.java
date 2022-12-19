package com.example.hibernatecrud_spring.service;

import com.example.hibernatecrud_spring.model.Role;
import com.example.hibernatecrud_spring.model.Status;
import com.example.hibernatecrud_spring.model.User;
import com.example.hibernatecrud_spring.repository.RoleRepository;
import com.example.hibernatecrud_spring.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User save(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        User registeredUser = userRepository.add(user);
        log.info("In method register - user {} successfully registered", registeredUser);
        return registeredUser;
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
