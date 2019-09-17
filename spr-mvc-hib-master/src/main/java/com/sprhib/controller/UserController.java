package com.sprhib.controller;

import com.sprhib.model.User;
import com.sprhib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller

public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/")
	public ModelAndView mainPage() {
		ModelAndView modelAndView = new ModelAndView("add-user-form");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	@RequestMapping(value="/index")
	public ModelAndView indexPage() {
		ModelAndView modelAndView = new ModelAndView("add-user-form");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	@RequestMapping(value="/user/add", method= RequestMethod.GET)
	public ModelAndView addUserPage() {
		ModelAndView modelAndView = new ModelAndView("add-user-form");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	@RequestMapping(value="/user/add", method=RequestMethod.POST)
	public ModelAndView addingUser(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView("list-of-users");
		userService.addUser(user);
		List<User> users = userService.getUsers();
		modelAndView.addObject("users", users);
		return modelAndView;
	}

	@RequestMapping(value="/user/list")
	public ModelAndView listOfUsers() {
		ModelAndView modelAndView = new ModelAndView("list-of-users");
		List<User> users = userService.getUsers();
		modelAndView.addObject("users", users);
		return modelAndView;
	}

	@RequestMapping(value="/user/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-user-form");
		User user = userService.getUser(id);
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@RequestMapping(value="/user/edit/{id}", method=RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute User user, @PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("list-of-users");
		user.setId(id);
		userService.updateUser(user);
		List<User> users = userService.getUsers();
		modelAndView.addObject("users", users);
		return modelAndView;
	}

	@RequestMapping(value="/user/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("list-of-users");
		userService.deleteUser(id);
		List<User> users = userService.getUsers();
		modelAndView.addObject("users", users);
		return modelAndView;
	}

}
