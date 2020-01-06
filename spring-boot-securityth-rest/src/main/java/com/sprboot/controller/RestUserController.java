package com.sprboot.controller;

import com.sprboot.model.User;
import com.sprboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestUserController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin/users")
    public List<User> users() {
        return userService.getUsers();
    }

    @PostMapping("/admin/createuser")
    public void addUser(@ModelAttribute User user, @RequestParam String role){
        userService.updateUser(user,role);
    }

    @PutMapping("/admin/edit/{id}")
    public void editUser(@ModelAttribute User user, @PathVariable Integer id, @RequestParam String role) {
        user.setId(id);
        userService.updateUser(user,role);
    }

    @DeleteMapping("/admin/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
