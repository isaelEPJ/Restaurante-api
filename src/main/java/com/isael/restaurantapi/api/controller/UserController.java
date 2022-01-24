package com.isael.restaurantapi.api.controller;

import com.isael.restaurantapi.domain.model.Cozinha;
import com.isael.restaurantapi.domain.model.User;
import com.isael.restaurantapi.domain.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public List<User> listAllUsers() {
        return userRepository.getUsers();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        if (newUser != null) {
            userRepository.createUser(newUser);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.noContent().build();
    }

    //    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable Long userId) {
        if (userId != null) {
            User user = userRepository.getUserById(userId);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.LOCATION, "http://novoendereço");
            return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
        }

    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        User userAtual = userRepository.getUserById(userId);
        if (userAtual != null) {
            BeanUtils.copyProperties(user, userAtual, "id");
            userRepository.createUser(userAtual);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<User> removeUser(@PathVariable Long userId) {
        User userSelected = userRepository.getUserById(userId);

        try {
            if (userSelected != null) {
                userRepository.removeUser(userSelected);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
