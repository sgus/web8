package ru.study.dao;


import ru.study.model.User;

import java.util.List;

public interface UserDAO {

    List getAllUsers();

    void addUser(User user);

    void removeUserByLogin(String login);

    User getUserById(long id);

    User getUserByLogin(String login);

    void removeUserById(Long id);

    void updateUser(User user);

    boolean validateUser(User user);

    User findUserByUsername(String username);


}
