package com.cheky.springboot.demo.controller;

import com.cheky.springboot.demo.dto.UserDTO;
import com.cheky.springboot.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 依据RESTful 实现CRUD
 * @author Cheky
 */
@RequiredArgsConstructor
@RestController()
@RequestMapping("jpa/users")
public class UserJpaController {

    private final UserService userService;

    //解决跨域问题 方法2 不推荐
//    @CrossOrigin({"http://127.0.0.1:8284", "http://127.0.0.1:5500"})
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
