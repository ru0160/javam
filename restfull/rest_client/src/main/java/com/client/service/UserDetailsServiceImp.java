package com.client.service;

import com.client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


@Service("UserDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    RestService restService;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String url = "http://localhost:8080/admin/getUserByName/" + username;
        User user = restService.getUserByName(username);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return  user;
    }
}
