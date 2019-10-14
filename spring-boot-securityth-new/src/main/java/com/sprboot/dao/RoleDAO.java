package com.sprboot.dao;


import com.sprboot.model.Role;

public interface RoleDAO {
    Role getRole(int id);
    void addRole(Role role);
}
