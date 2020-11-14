package com.cheky.springboot.demo.controller;

import com.cheky.springboot.demo.entity.User;
import com.cheky.springboot.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserJPAController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("jpa/user/{id}")
    public User GetUser(@PathVariable("id") Integer id){
        return userRepository.getOne(id);
    }

    @GetMapping("jpa/user")
    public User insertUser(User user){
        return userRepository.save(user);
    }
}
