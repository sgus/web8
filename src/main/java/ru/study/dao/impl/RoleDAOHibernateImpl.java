package ru.study.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.study.dao.RoleDAO;
import ru.study.dao.UserDAO;
import ru.study.model.Role;
import ru.study.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("roleDAO")
@Transactional
public class RoleDAOHibernateImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Role> getAllRoles() {
        List query = entityManager.createQuery("SELECT u FROM Role u", Role.class).getResultList();
        System.out.println(query);
        return query;
    }

    @Override
    public void addRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public Role getRoleById(long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role getRoleByName(String name) {
        Query query = entityManager.createQuery("from Role where name = :name");
        query.setParameter("name", name);
        return (Role) query.getResultList().get(0);

    }

    @Override
    public void removeRoleById(Long id) {
        Query query = entityManager.createQuery("delete from Role where id = :ID");
        query.setParameter("ID", id);
        query.executeUpdate();
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);

    }
}
