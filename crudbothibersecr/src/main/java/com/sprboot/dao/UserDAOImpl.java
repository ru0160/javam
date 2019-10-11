package com.sprboot.dao;

import com.sprboot.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    EntityManager em;

    public void addUser(User user) {
        em.persist(user);
    }
    public void updateUser(User user) {
        em.merge(user);
    }

    public User getUser(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User getUserByName(String name) {
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u WHERE u.name = :name", User.class);
        return query.setParameter("name", name).getSingleResult();
    }

    public void deleteUser(int id) {
        em.remove(em.find(User.class,id));
    }

    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        List<User> users = em
                .createQuery("from User")
                .getResultList();
        return users;
    }
}
