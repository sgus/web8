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
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<User> getAllUsers() {
        List query = currentSession().createQuery("FROM User").getResultList();
        System.out.println(query);
        return query;
    }

    @Override
    public void addUser(User user) {
        currentSession().save(user);
    }

    @Override
    public void removeUserByLogin(String login) {
        Query query = currentSession().createQuery("delete from User where login=:login");
        query.setParameter("login", login).executeUpdate();
    }

    @Override
    public User getUserById(long id) {
        return currentSession().get(User.class, id);
    }

    @Override
    public User getUserByLogin(String login) {
        return currentSession().find(User.class, login);
    }

    @Override
    public void removeUserById(Long id) {
        Query query = currentSession().createQuery("delete from User where id = :ID");
        query.setParameter("ID", id);
        query.executeUpdate();

    }

    @Override
    public void updateUser(User user) {
        String hql = "UPDATE User" +
                " set email =: email, " +
                "  login =: login, " +
                "  password =: password, " +
                "  rating =: rating, " +
                "  role =: role " +
                "WHERE id =:id";
        Query query = currentSession().createQuery(hql);
        query.setParameter("email", user.getEmail());
        query.setParameter("login", user.getLogin());
        query.setParameter("password", user.getPassword());
        query.setParameter("rating", user.getRating());
        query.setParameter("role", user.getRole());
        query.setParameter("id", user.getId());
        query.executeUpdate();

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
