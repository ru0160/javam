package com.sprboot.controller;

import com.sprboot.model.Role;
import com.sprboot.model.User;
import com.sprboot.service.RoleService;
import com.sprboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class RestUserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/admin/allRoles")
    public List<Role> roles(){
        return roleService.getRoles();
    }

    @GetMapping("/admin/users")
    public List<User> users() {
        return userService.getUsers();
    }

    @GetMapping("/admin/getUserById/{id}")
    public User user(@PathVariable @NotNull Integer id) {
        return userService.getUser(id);
    }

    @PostMapping("/admin/createuser/")
    public void addUser(@RequestBody User user){
        String role = new String();
        for(Role roleInp : user.getRoles()){
            role = roleInp.getName();
        }
        userService.updateUser(user,role);
    }

    @PutMapping("/admin/edit/")
    public void editUser(@RequestBody User user) {
        User userEdit = userService.getUser(user.getId());
        String role = new String();
        for(Role roleInp : user.getRoles()){
            role = roleInp.getName();
        }
        userEdit.setName(user.getName());
        user.setPassword(user.getPassword());
        userService.updateUser(user,role);
    }

    @DeleteMapping("/admin/delete/")
    public void deleteUser(@RequestParam  int id){
        userService.deleteUser(id);
    }
}
