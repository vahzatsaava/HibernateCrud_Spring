package com.example.hibernatecrud_spring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "roles")
    private List<User> users;

}
