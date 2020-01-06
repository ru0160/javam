package com.client.service;

import com.client.model.Role;
import com.client.model.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service("rest")
public class RestService {

    private final RestTemplate restTemplate;

    public RestService() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        this.restTemplate = restTemplateBuilder
                .basicAuthentication("admin", "admin2")
                .build();

    }
    public User getUserByName(String userName) {
        String url = "http://localhost:8080/admin/getUserByName/" + userName;
        return restTemplate.getForObject(url,User.class);
    }
    public List<User> getAllUsers(){
        String url = "http://localhost:8080/admin/users";
        User[] users = restTemplate.getForObject(url,User[].class);
        return Arrays.asList(users);
    }
    public List<Role> getAllroles(){
        String url = "http://localhost:8080/admin/allRoles";
        Role[] roles = restTemplate.getForObject(url,Role[].class);
        return Arrays.asList(roles);
    }
    public User getUserById(int id){
        String url = "http://localhost:8080/admin/getUserById/" + id;
        return restTemplate.getForObject(url,User.class);
    }
    public void deleteUser(int id){
        String url = "http://localhost:8080/admin/delete/?id=" + id;
        restTemplate.delete(url);
    }
    public void editUses(User user){
        String role = new String();
        for(Role roleInp : user.getRoles()){
            role = roleInp.getName();
        }
        String url = "http://localhost:8080/admin/edit/";
        restTemplate.put(url,user,role);
    }
    public void createUser(User user){
        String role = new String();
        for(Role roleInp : user.getRoles()){
            role = roleInp.getName();
        }
        String url = "http://localhost:8080/admin/createuser/";
        restTemplate.postForObject(url,user,User.class,role);
    }

}