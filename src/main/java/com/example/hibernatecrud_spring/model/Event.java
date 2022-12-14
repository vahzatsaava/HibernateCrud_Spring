package com.example.hibernatecrud_spring.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Data
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    @JsonIgnore
    private File file;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    @JsonIgnore
    private User user;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;


    public Event(File file, User user, Role role) {
        this.file = file;
        this.user = user;
        this.role = role;
    }

    public Event(int id, File file, User user, Role role) {
        this.id = id;
        this.file = file;
        this.user = user;
        this.role = role;
    }
}
