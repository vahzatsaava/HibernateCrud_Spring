package com.example.hibernatecrud_spring.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username",unique = true)
    private String userName;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "password")
    @JsonIgnore
    private String password;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
    joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id" )},
    inverseJoinColumns = {@JoinColumn(name = "roles_id",referencedColumnName = "id")})
    private List<Role> roles = new ArrayList<>();
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Event> events;


    public User(Long id, String userName, String email, String first_name, String last_name, String password, Status status) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.status = status;
    }

    public User(String userName, String email, String first_name, String last_name, String password, Status status) {
        this.userName = userName;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.status = status;
    }
}
