package com.sprhib.service;

import com.sprhib.dao.RoleDAO;
import com.sprhib.dao.UserDAO;
import com.sprhib.model.Role;
import com.sprhib.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RoleDAO roleDAO;

    public void addUser(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getRole(1));
        user.setRoles(roles);
        userDAO.addUser(user);
    }


    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    public User getUserByName(String name) {
        return userDAO.getUserByName(name);
    }

    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    public List<User> getUsers() {
        return userDAO.getUsers();
    }
}