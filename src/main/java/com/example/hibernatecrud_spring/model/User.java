package com.example.hibernatecrud_spring.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "password")
    private String password;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "user_roles",
    joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id" )},
    inverseJoinColumns = {@JoinColumn(name = "roles_id",referencedColumnName = "id")})
    @ToString.Exclude
    @JsonIgnore
    private List<Role> roles;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Event> events;


    public User(int id, String userName, String email, String first_name, String last_name, String password, Status status) {
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
