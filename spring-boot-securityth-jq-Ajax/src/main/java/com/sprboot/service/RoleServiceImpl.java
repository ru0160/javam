package com.sprboot.service;

import com.sprboot.model.Role;
import com.sprboot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
@Autowired
    RoleRepository roleRepository;
    @Override
    public List<Role> getRoles() {
        return (List<Role>) roleRepository.findAll();
    }
}
