package ru.study.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
@Table(name = "users", schema = "web6_db")
@Data
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "login")
    private String login;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "clientCourse",
            joinColumns = {
                    @JoinColumn(name = "user_id",
                            referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id",
                            referencedColumnName = "id")
            })
    List<Role> roles = new ArrayList<Role>();


    @Column(name = "rating")
    @ColumnDefault("0")
    private Long rating;

    public User() {
    }

    public User(long id, String login, String email, String password, List<Role> roles, Long rating) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.rating = rating;
    }

    public User(String name, String email, String password) {
        this.login = name;
        this.email = email;
        this.password = password;
    }

    public User(String login, String email, String password, List<Role> roles, Long rating) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.rating = rating;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + this.id +
                ", login='" + this.login + '\'' +
                ", email='" + this.email + '\'' +
                ", password='" + this.password + '\'' +
                ", role='" + this.roles.toString() + '\'' +
                ", rating=" + this.rating +
                '}';
    }
}
