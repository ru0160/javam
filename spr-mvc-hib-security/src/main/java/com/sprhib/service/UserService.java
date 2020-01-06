package com.sprhib.service;

import com.sprhib.model.User;
import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    User getUser(int id);
    User getUserByName(String name);
    void deleteUser(int id);
    List<User> getUsers();
}
