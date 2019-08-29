package ru.study.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.study.dao.UserDAO;
import ru.study.model.User;
import ru.study.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO dao;



    @Autowired
    public UserServiceImpl(UserDAO dao) {
        this.dao = dao;
    }


    @Override
    public User getUserById(long id) {
        return dao.getUserById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return dao.getUserByLogin(login);
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteById(Long id) {
        dao.removeUserById(id);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public boolean checkUser(User user) {
        return dao.validateUser(user);
    }
}
