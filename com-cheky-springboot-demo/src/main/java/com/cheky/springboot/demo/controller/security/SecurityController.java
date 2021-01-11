package com.cheky.springboot.demo.controller.security;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author Cheky
 * @date 2021-01-11
 *
 * Reference: https://blog.csdn.net/jpgzhu/article/details/105200598
 *
 * 测试步骤：
 * 1、获取Token
 * http://localhost:8084/login-view
 * 2、测试 账号登录和不登录时，以下 URL的访问权限
 * http://localhost:8084/security/admin 仅登录时才可访问
 * http://localhost:8084/security/user 仅登录时才可访问
 * http://localhost:8084/security 均可访问
 */
@Slf4j
@RestController
//@RequestMapping("security")
@Api(tags = "系统授权接口")
public class SecurityController {

    private final JwtTokenUtils jwtTokenUtils;

    public SecurityController(JwtTokenUtils jwtTokenUtils) {
        this.jwtTokenUtils = jwtTokenUtils;
    }

    @ApiOperation("登录授权")
    @PostMapping("login")
    public String login(String username,String password){
        Map map = new HashMap();
        map.put("username",username);
        map.put("password",password);
        List<String> roles = new ArrayList();
        roles.add("admin");
        map.put("roles", roles);
        var result = jwtTokenUtils.createToken(map);
        return result;
    }

    @GetMapping("security")
    public String hello(){
        return "hello, spring security!";
    }

    @GetMapping("security/admin")
    @PreAuthorize("hasAuthority('admin')")
    public String helloAdmin(){
        return "hello, the role of admin!";
    }

    @GetMapping("security/user")
    @PreAuthorize("hasAnyAuthority('normal', 'admin')")
    public String helloUser(){
        return "hello, the role of user!";
    }

    @PostMapping("security/login-success")
    public String loginSuccess(){
        return "hello, spring security login-success!";
    }
}
