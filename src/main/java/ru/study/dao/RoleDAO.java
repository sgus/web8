package ru.study.dao;


import ru.study.model.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> getAllRoles();

    void addRole(Role role);

    Role getRoleById(long id);

    Role getRoleByName(String name);

    void removeRoleById(Long id);

    void updateRole(Role role);
}
