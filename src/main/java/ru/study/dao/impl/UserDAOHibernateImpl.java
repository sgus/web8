package ru.study.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.study.dao.UserDAO;
import ru.study.model.User;

import javax.persistence.Query;
import java.util.List;

@Repository("userDAO")
public class UserDAOHibernateImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<User> getAllUsers() {
        List query = currentSession().createQuery("FROM User").getResultList();
        System.out.println(query);
        return query;
    }

    @Override
    public void addUser(User user) {
        currentSession().persist(user);
    }

    @Override
    public void removeUserByLogin(String login) {
        Query query = currentSession().createQuery("delete from User where login=:login");
        query.setParameter("login", login).executeUpdate();
    }

    @Override
    public User getUserById(long id) {
        return currentSession().getReference(User.class, id);
    }

    @Override
    public User getUserByLogin(String login) {
        return currentSession().find(User.class, login);
    }

    @Override
    public void removeUserById(Long id) {
        Query query = currentSession().createQuery("delete from User where id =:id");
        query.setParameter("id", id).executeUpdate();
    }

    @Override
    public void updateUser(User user) {
        currentSession().merge(user);

    }

    @Override
    public boolean validateUser(User user) {
        User userByLogin = getUserByLogin(user.getLogin());
        if (user.getPassword().equals(userByLogin.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
