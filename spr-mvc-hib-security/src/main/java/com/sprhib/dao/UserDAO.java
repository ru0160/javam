package com.sprhib.dao;

import com.sprhib.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    void updateUser(User user);
    User getUser(int id);
    User getUserByName(String name);
    void deleteUser(int id);
    List<User> getUsers();

}
