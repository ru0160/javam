package com.sprboot.controller;

import com.sprboot.model.Role;
import com.sprboot.service.UserService;
import com.sprboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/hi")
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @RequestMapping(value="/register", method= RequestMethod.GET)
    public ModelAndView addUserPage() {
        ModelAndView modelAndView = new ModelAndView("add-user-form");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value="/register/add", method=RequestMethod.POST)
    public ModelAndView addingUser(@ModelAttribute User user, @RequestParam String role) {
        userService.updateUser(user,role);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin/listUsers");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/listUsers")
    public ModelAndView listOfUsers() {
        ModelAndView modelAndView = new ModelAndView("list-of-users");
        List<User> users = userService.getUsers();
        modelAndView.addObject("users", users);
        return modelAndView;
    }


    @RequestMapping(value = "/admin/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editUserPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-user-form");
        User user = userService.getUser(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute User user, @PathVariable Integer id, @RequestParam String role) {
        ModelAndView modelAndView = new ModelAndView("list-of-users");
        user.setId(id);
        userService.updateUser(user,role);
        List<User> users = userService.getUsers();
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUserById(@PathVariable Integer id) {
        userService.deleteUser(id);
        ModelAndView mv = new ModelAndView("redirect:/admin/listUsers");
        return mv;
    }

}
