package com.sprboot.service;

import com.sprboot.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user, String role);
    User getUser(int id);
    User getUserByName(String name);
    void deleteUser(int id);
    List<User> getUsers();
}
