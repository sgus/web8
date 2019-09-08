package ru.study.service;


import ru.study.model.Role;

import java.util.List;

public interface RoleService {

    public List<Role> getAllRoles();

    public void addRole(Role role) ;

    public Role getRoleById(long id) ;

    public Role getRoleByName(String name) ;

    public void deleteById(Long id);

    public void updateRole(Role role);


}
