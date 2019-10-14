package com.sprboot.dao;

import com.sprboot.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO {
    @PersistenceContext
    EntityManager em;
    @Override
    public Role getRole(int id) {
        return em.find(Role.class, id);
    }

    @Override
    public void addRole(Role role) {
        em.persist(role);
    }

}
