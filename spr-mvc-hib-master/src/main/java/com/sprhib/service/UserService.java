package com.sprhib.service;

import java.util.List;

import com.sprhib.model.User;

public interface UserService {
	void addTeam(User user);
	void updateTeam(User user);
	User getTeam(int id);
	void deleteTeam(int id);
	List<User> getTeams();

}
