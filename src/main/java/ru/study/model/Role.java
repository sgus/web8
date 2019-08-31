package ru.study.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles", schema = "web6_db")
@Data
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false)
    private String name;
    @OneToMany(mappedBy="role", cascade=CascadeType.ALL)
    private List<User> contacts ;
}
