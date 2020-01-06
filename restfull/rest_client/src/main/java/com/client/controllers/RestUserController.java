package com.client.controllers;

import com.client.model.Role;
import com.client.model.User;
import com.client.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@RestController
public class RestUserController {
    @Autowired
    RestService restService;

    @GetMapping("/admin/users")
    public List<User> users() {
        return restService.getAllUsers();
    }
    @GetMapping("/admin/allRoles")
    public List<Role> roles(){
        return restService.getAllroles();
    }
    @GetMapping("/admin/getUserById/{id}")
    public Object user(@PathVariable @NotNull Integer id) {
        return restService.getUserById(id);
    }
    @GetMapping("/admin/getUserByName/{name}")
    public User user(@PathVariable @NotNull String name) {
        return restService.getUserByName(name);
    }
    @DeleteMapping("/admin/delete/")
    public void deleteUser(@RequestParam int id){
        restService.deleteUser(id);
    }
    @PutMapping("/admin/edit/")
    public void editUser(@RequestBody User user) {
        restService.editUses(user);
    }

    @PostMapping("/admin/createuser/")
    public void addUser(@RequestBody User user){
        restService.createUser(user);
    }
}
