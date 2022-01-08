package com.isael.restaurantapi.infrastructure.repository;

import com.isael.restaurantapi.domain.model.User;
import com.isael.restaurantapi.domain.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<User> getUsers() {
        return manager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return manager.find(User.class, id);
    }

    @Override
    public User createUser(User user) {
        return manager.merge(user);
    }

    @Override
    public boolean removeUser(User user) {
        user = getUserById(user.getId());
        manager.remove(user);
        return true;
    }
}
