package ru.study.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles", schema = "web6_db")
@Data
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> contacts;
    @ManyToMany(mappedBy = "roles",
            cascade = CascadeType.ALL)
   private Set<User> users;

    public Role() {
    }
}
