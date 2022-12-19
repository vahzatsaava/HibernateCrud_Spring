package com.example.hibernatecrud_spring.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;

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
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "file")
    @ToString.Exclude
    private Event event;

    public File(int id, String fileName, String location, Status status) {
        this.id = id;
        this.fileName = fileName;
        this.location = location;
        this.status = status;
    }

    public File(String fileName, String location, Status status) {
        this.fileName = fileName;
        this.location = location;
        this.status = status;
    }
}
