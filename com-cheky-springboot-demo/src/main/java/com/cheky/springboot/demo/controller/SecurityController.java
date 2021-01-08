package com.cheky.springboot.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security")
public class SecurityController {

    @GetMapping
    public String hello(){
        return "hello, spring security!";
    }

    @GetMapping("admin")
    @PreAuthorize("hasAnyRole('admin')")
    public String helloAdmin(){
        return "hello, the role of admin!";
    }

    @GetMapping("user")
    @PreAuthorize("hasAnyRole('normal', 'admin')")
    public String helloUser(){
        return "hello, the role of user!";
    }

    @PostMapping("login-success")
    public String loginSuccess(){
        return "hello, spring security login-success!";
    }
}
