package com.example.hibernatecrud_spring.repository;

import com.example.hibernatecrud_spring.model.User;
import org.springframework.stereotype.Component;


public interface UserRepository extends GenericRepository<User,Integer> {
    User findByUserName(String userName);
}
