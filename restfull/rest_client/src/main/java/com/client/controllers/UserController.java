package com.client.controllers;


import com.client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping(value = "/admin/listUsers")
    public ModelAndView listOfUsers() {
        ModelAndView modelAndView = new ModelAndView("list-of-users");
        List<User> users = new ArrayList<>();
        modelAndView.addObject("users", users);
        return modelAndView;
    }
    @RequestMapping(value = "/user/hi")
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
    @GetMapping("text")
    public @ResponseBody String getResponse(){
        return "Hello world";
    }

}
