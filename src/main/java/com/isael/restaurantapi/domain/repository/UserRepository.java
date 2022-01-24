package com.isael.restaurantapi.domain.repository;

import com.isael.restaurantapi.domain.model.User;

import javax.persistence.GeneratedValue;
import java.util.List;

public interface UserRepository {

    @GeneratedValue

    public List<User> getUsers();

    public User getUserById(Long id);

    public User updateUser(Long id, User user);

    public User createUser(User user);

    public boolean removeUser(User user);
}
