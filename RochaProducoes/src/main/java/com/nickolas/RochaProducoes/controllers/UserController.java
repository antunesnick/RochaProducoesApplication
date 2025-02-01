package com.nickolas.RochaProducoes.controllers;


import com.nickolas.RochaProducoes.models.User;
import com.nickolas.RochaProducoes.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    final private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "")
    public User getUser(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping(path = "")
    public List<User> getUsers() {
        return userService.findAllUsers();
    }

    @PostMapping(path = "")
    public User createUser(@RequestBody User user) {
        userService.createUser(user);
        return user;
    }

    @PutMapping(path = "")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping(path = "")
    public void deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
    }


}
