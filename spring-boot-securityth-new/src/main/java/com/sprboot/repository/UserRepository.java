package com.sprboot.repository;

import com.sprboot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findById(long id);
    User findByName(String name);
}
