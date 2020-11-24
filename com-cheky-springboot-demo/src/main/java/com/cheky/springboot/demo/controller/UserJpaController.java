package com.cheky.springboot.demo.controller;

import com.cheky.springboot.demo.dao.UserDAO;
import com.cheky.springboot.demo.dto.UserDTO;
import com.cheky.springboot.demo.model.UserDO;
import com.cheky.springboot.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Cheky
 * 依据RESTful 实现CRUD
 */
@RequiredArgsConstructor
@RestController()
@RequestMapping("jpa/user")
public class UserJpaController {

    private final UserService userService;

    @GetMapping("{id}")
    public UserDTO getUser(@PathVariable("id") final Integer id){
        return userService.findById(id);
    }

    @PostMapping
    public ResponseEntity insertUser(@RequestBody UserDTO user){
        userService.insert(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable("id") final Integer id){
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity updateUser(@PathVariable("id") final Integer id,final UserDTO user){
        user.setId(id);
        userService.update(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
