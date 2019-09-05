package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.User;

public interface UserDAO {
	 void addUser(User user);
	 void updateUser(User user);
	 User getUser(int id);
	 void deleteUser(int id);
	 List<User> getUsers();

}
