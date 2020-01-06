package com.sprboot.service;

import com.sprboot.model.Role;
import com.sprboot.model.User;
import com.sprboot.repository.RoleRepository;
import com.sprboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public void addUser(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findById(1));
        user.setRoles(roles);
        userRepository.save(user);
    }


    public void updateUser(User user) {
        userRepository.save(user);
    }

    public User getUser(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
}