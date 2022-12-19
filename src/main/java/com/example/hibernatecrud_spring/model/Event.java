package com.example.hibernatecrud_spring.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    @CreatedDate
    @Column(name = "created")
    private Date created;
    //@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")

    @LastModifiedDate
    @Column(name = "updated")
    private Date updated;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    @JsonIgnore
    private File file;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    @JsonIgnore
    private User user;


    public Event(Date created, Date updated, Status status, File file, User user) {
        this.created = created;
        this.updated = updated;
        this.status = status;
        this.file = file;
        this.user = user;
    }
}
