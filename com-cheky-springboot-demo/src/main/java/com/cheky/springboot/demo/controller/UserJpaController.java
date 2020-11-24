package com.cheky.springboot.demo.controller;

import com.cheky.springboot.demo.dao.UserDAO;
import com.cheky.springboot.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Cheky
 * 依据RESTful 实现CRUD
 */
@RestController()
@RequestMapping("/jpa/user")
public class UserJpaController {

    @Autowired
    UserDAO userDAO;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id){
        var existsUser = userDAO.existsById(id);
        if (existsUser) {
            return userDAO.findById(id).get();
        } else {
            throw new RuntimeException("该用户不存在! id="+id);
        }
    }

    @PostMapping
    public User insertUser(User user){
        var userId = user.getId();
        if (userId == null) {
            return userDAO.save(user);
        } else {
            throw new RuntimeException("id 为自动生成key，请勿赋值");
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        var existsUser = userDAO.existsById(id);
        if (existsUser) {
            userDAO.deleteById(id);
            return "删除成功！id=" + id;
        } else {
            return "无此用户 id=" + id;
        }

    }

    @PutMapping
    public User updateUser(User user){
        var existsUser = userDAO.existsById(user.getId());
        if (existsUser) {
            return userDAO.save(user);
        } else {
            throw new RuntimeException("该用户不存在! id="+user.getId());
        }
    }
}
