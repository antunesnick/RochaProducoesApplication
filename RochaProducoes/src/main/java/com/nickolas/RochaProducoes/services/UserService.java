package com.nickolas.RochaProducoes.services;


import com.nickolas.RochaProducoes.models.User;
import com.nickolas.RochaProducoes.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    public void createUser(User user) {
         this.userRepository.save(user);
    }

    public User updateUser(User user) {
        if(findUserByEmail(user.getEmail()) != null) {
            this.userRepository.save(user);
            return user;
        };
        return null;
    }

    public void deleteUser(String email) {
        User user = this.findUserByEmail(email);
        if(user != null) {
            this.userRepository.delete(user);
        }
    }





}
