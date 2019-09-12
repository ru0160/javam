package com.sprhib.controller;

import com.sprhib.DAO.UserDAO;
import com.sprhib.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class UserController {

	@Autowired
	private UserDAO userDAO;

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
	public ModelAndView addTeamPage() {
		ModelAndView modelAndView = new ModelAndView("add-user-form");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
//
//	@RequestMapping(value="/user/add", method=RequestMethod.POST)
//	public ModelAndView addingTeam(@ModelAttribute User user) {
//		ModelAndView modelAndView = new ModelAndView("list-of-users");
//		userRepository.save(user);
//		List<User> users = userRepository.findAll();
//		modelAndView.addObject("users", users);
//		return modelAndView;
//	}
//
//	@RequestMapping(value="/user/list")
//	public ModelAndView listOfTeams() {
//		ModelAndView modelAndView = new ModelAndView("list-of-users");
//        List<User> users = userRepository.findAll();
//		modelAndView.addObject("users", users);
//		return modelAndView;
//	}
//
//	@RequestMapping(value="/user/edit/{id}", method=RequestMethod.GET)
//	public ModelAndView editTeamPage(@PathVariable Integer id) {
//		ModelAndView modelAndView = new ModelAndView("edit-user-form");
//		User user = userService.getTeam(id);
//		modelAndView.addObject("user", user);
//		return modelAndView;
//	}
//
//	@RequestMapping(value="/user/edit/{id}", method=RequestMethod.POST)
//	public ModelAndView edditingTeam(@ModelAttribute User user, @PathVariable Integer id) {
//		ModelAndView modelAndView = new ModelAndView("list-of-users");
//		userService.updateTeam(user);
//		List<User> users = userService.getTeams();
//		modelAndView.addObject("users", users);
//		return modelAndView;
//	}
//
//	@RequestMapping(value="/user/delete/{id}", method=RequestMethod.GET)
//	public ModelAndView deleteTeam(@PathVariable Integer id) {
//		ModelAndView modelAndView = new ModelAndView("list-of-users");
//		userService.deleteTeam(id);
//		List<User> users = userService.getTeams();
//		modelAndView.addObject("users", users);
//		return modelAndView;
//	}

}
