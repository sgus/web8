package ru.study.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity(name = "User")
@Table(name = "users", schema = "web6_db")
@Data
public class User   {
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
    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = {
                    @JoinColumn(name = "user_id",
                            referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id",
                            referencedColumnName = "id")
            })
    private Set<Role> roles;


    @Column(name = "rating")
    @ColumnDefault("0")
    private Long rating;


    public User() {
    }

//
//    public User(long id, String login, String email, String password, long role, Long rating) {
//        this.id = id;
//        this.login = login;
//        this.email = email;
//        this.password = password;
//        this.role = role;
//        this.rating = rating;
//    }
//
//    public User(String name, String email, String password) {
//        this.login = name;
//        this.email = email;
//        this.password = password;
//    }
//
//    public User(String login, String email, String password, Role role, Long rating) {
//        this.login = login;
//        this.email = email;
//        this.password = password;
//        this.role = role;
//        this.rating = rating;
//    }
//
//    public User(String login, String password) {
//        this.login = login;
//        this.password = password;
//    }
//
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + this.id +
//                ", login='" + this.login + '\'' +
//                ", email='" + this.email + '\'' +
//                ", password='" + this.password + '\'' +
//                ", role='" + this.role.getName() + '\'' +
//                ", rating=" + this.rating +
//                '}';
//    }
}
