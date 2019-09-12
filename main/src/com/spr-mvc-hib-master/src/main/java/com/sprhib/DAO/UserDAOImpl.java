package com.sprhib.DAO;

import com.sprhib.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
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
        User user = em.find(User.class, id);
        return user;
    }

    public void deleteUser(int id) {
        em.remove(this.getUser(id));
    }
//   Список тоже не получается сделать
//    public List<User> getUser() {
//        Query query = em.createQuery("Select User FROM users");
//        List<User> result = query.getResultList();
//        return result
//    }

}

