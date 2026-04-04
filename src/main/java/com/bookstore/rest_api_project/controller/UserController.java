package com.bookstore.rest_api_project.controller;

import java.util.List;

import com.bookstore.rest_api_project.model.User;
import com.bookstore.rest_api_project.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users")
    public List<User> getAllUsers() {return userRepo.findAll();}
    
    @PostMapping("/users/create")
    public User newUser(@RequestBody User newUser) {
        return userRepo.save(newUser);
    }
}
