package com.sprhib.dao;

import com.sprhib.model.Role;

public interface RoleDAO {
    Role getRole(int id);
    void addRole(Role role);
}
