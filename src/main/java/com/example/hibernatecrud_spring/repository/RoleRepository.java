package com.example.hibernatecrud_spring.repository;

import com.example.hibernatecrud_spring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(String name);
}
