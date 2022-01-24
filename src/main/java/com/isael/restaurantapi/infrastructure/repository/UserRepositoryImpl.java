package com.isael.restaurantapi.infrastructure.repository;

import com.isael.restaurantapi.domain.model.User;
import com.isael.restaurantapi.domain.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entity;


    @Override
    public List<User> getUsers() {
        return entity.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entity.find(User.class, id);
    }

    @Override
    @Transactional
    public User updateUser(Long id, User user) {
        List<User> userSelected = entity.createQuery("from User", User.class).getResultList();
//        if (userSelected.size() > 0) {
//            for (User user1 : userSelected) {
//                if (user1.getId() == id) {
//                    user.setId(id);
//                    createUser(user1);
//                    return user1;
//                }
//            }
//        }
        return null;
    }

    @Override
    @Transactional
    public User createUser(User user) {
        return entity.merge(user);
    }

    @Override
    @Transactional
    public boolean removeUser(User user) {
        user = getUserById(user.getId());
        entity.remove(user);
        return true;
    }
}
