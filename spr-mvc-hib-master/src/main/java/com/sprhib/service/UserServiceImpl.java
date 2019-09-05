package com.sprhib.service;

import java.util.List;

import com.sprhib.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.UserDAO;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	public void addTeam(User user) {
		userDAO.addUser(user);
	}

	public void updateTeam(User user) {
		userDAO.updateUser(user);
	}

	public User getTeam(int id) {
		return userDAO.getUser(id);
	}

	public void deleteTeam(int id) {
		userDAO.deleteUser(id);
	}

	public List<User> getTeams() {
		return userDAO.getUsers();
	}

}
