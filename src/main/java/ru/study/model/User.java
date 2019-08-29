package ru.study.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

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
    @Column(name = "role")
    @ColumnDefault("user")
    private String role;
    @Column(name = "rating")
    @ColumnDefault("0")
    private Long rating;

    public User() {
    }

    public User(long id, String login, String email, String password, String role, Long rating) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
        this.rating = rating;
    }

    public User(String name, String email, String password) {
        this.login = name;
        this.email = email;
        this.password = password;
    }

    public User(String login, String email, String password, String role, Long rating) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
        this.rating = rating;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", rating=" + rating +
                '}';
    }
}
