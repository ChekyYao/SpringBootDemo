package com.cheky.dubbo.demo.controller;

import com.cheky.dubbo.demo.dto.UserDTO;
import com.cheky.dubbo.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 依据RESTful 实现CRUD
 * @author Cheky
 * @date 2020-11-26
 */
@RequiredArgsConstructor
@RestController()
@RequestMapping("users")
public class UserController {

    @DubboReference
    private UserService userService;

    /**
     * 依据id查询User
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public UserDTO getUser(@PathVariable("id") final Integer id){

        return userService.findById(id);
    }

    /**
     * 新增User
     * @param user
     * @return
     */
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
    public ResponseEntity updateUser(@PathVariable("id") final Integer id, @RequestBody final UserDTO user){
        user.setId(id);
        userService.update(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
