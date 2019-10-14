package com.sprboot.service;

import com.sprboot.dao.UserDAO;
import com.sprboot.model.Role;
import com.sprboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            User user = userDAO.getUserByName(username);

            org.springframework.security.core.userdetails.User.UserBuilder builder = null;
            if (user != null) {
                builder = org.springframework.security.core.userdetails.User.withUsername(username);
                builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
                for(Role role : user.getRoles()){
                builder.roles(role.getName());}
            } else {
                throw new UsernameNotFoundException("User not found.");
            }

            return builder.build();

    }
}
