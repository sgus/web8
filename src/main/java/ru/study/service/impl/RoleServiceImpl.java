package ru.study.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.study.dao.RoleDAO;
import ru.study.dao.UserDAO;
import ru.study.model.Role;
import ru.study.model.User;
import ru.study.service.RoleService;
import ru.study.service.UserService;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    public void addRole(Role role) {
        roleDAO.addRole(role);
    }

    @Override
    public Role getRoleById(long id) {
        return roleDAO.getRoleById(id);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }

    @Override
    public void deleteById(Long id) {
        roleDAO.removeRoleById(id);
    }

    @Override
    public void updateRole(Role role) {
        roleDAO.updateRole(role);
    }
}
