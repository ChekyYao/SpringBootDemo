package com.cheky.springboot.demo.controller;

import com.cheky.springboot.demo.dao.UserDAO;
import com.cheky.springboot.demo.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Cheky
 * 依据RESTful 实现CRUD
 */
@RestController()
@RequestMapping("jpa/user")
public class UserJpaController {

    @Autowired
    UserDAO userDAO;

    @GetMapping("{id}")
    public UserDO getUser(@PathVariable("id") final Integer id){
        var existsUser = userDAO.existsById(id);
        if (existsUser) {
            return userDAO.findById(id).get();
        } else {
            throw new RuntimeException("该用户不存在! id="+id);
        }
    }

    @PostMapping
    public ResponseEntity insertUser(@RequestBody UserDO user){
        userDAO.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable("id") final Integer id){
        userDAO.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity updateUser(@PathVariable("id") final Integer id,final UserDO user){
        user.setId(id);
        userDAO.save(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
