package com.sprboot.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name = "id",  unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(int id, String name, String password, Set<Role> role) {
        this.setId(id);
        this.setName(name);
        this.setPassword(password);
        this.setRoles(role);

    }



    public String getPassword() {
        return this.password;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> role) {
        this.roles = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}