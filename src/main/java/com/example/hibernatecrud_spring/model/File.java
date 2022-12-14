package com.example.hibernatecrud_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.transaction.Transactional;

@NoArgsConstructor
@Data
@Entity
@Table(name = "files")

public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fileName")
    private String fileName;
    @Column(name = "location")
    private String location;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "file")
    @ToString.Exclude
    private Event event;

    public File(int id, String fileName, String location, Role role) {
        this.id = id;
        this.fileName = fileName;
        this.location = location;
        this.role = role;

    }

    public File(String fileName, String location, Role role) {
        this.fileName = fileName;
        this.location = location;
        this.role = role;
    }
}
