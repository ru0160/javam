package com.sprboot.controller;

import com.sprboot.model.Role;
import com.sprboot.model.User;
import com.sprboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class RestUserController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin/users")
    public List<User> users() {
        return userService.getUsers();
    }

    @GetMapping("/admin/getUserById/{id}")
    public User user(@PathVariable @NotNull Integer id) {
        return userService.getUser(id);
    }

    @PostMapping("/admin/createuser/")
    public void addUser(@ModelAttribute User user, @RequestParam String role){
        userService.updateUser(user,role);
    }

    @PutMapping("/admin/edit/")
    public void editUser(@RequestBody User user, @RequestParam String role) {
        User userEdit = userService.getUser(user.getId());
        userEdit.setName(user.getName());
        user.setPassword(user.getPassword());
        userService.updateUser(user,role);
    }

    @DeleteMapping("/admin/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
