package com.example.hibernatecrud_spring.model;

import lombok.Data;
import javax.persistence.*;
@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}


