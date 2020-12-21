package com.cheky.springboot.demo.controller;


import com.cheky.springboot.demo.config.JwtTokenConfig;
import com.cheky.springboot.demo.model.LoginUserDO;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;
import java.util.Arrays;
import java.util.List;

/**
 * @author cheky
 * @date 2020-12-21
 */
@RestController
@RequestMapping("jwt")
public class JwtController {
    @Autowired
    private JwtTokenConfig jwtToken;

    @PostMapping("/login")
    public String login(@RequestBody LoginUserDO user) {
// 1. 验证用户名和密码
// 2. 验证成功生成token
        String token = jwtToken.generateToken(user);
        return token;
    }

    @GetMapping("/getUserInfo")
    public String getUserInfo(@RequestHeader("Authorization") String authHeader) throws AuthenticationException {
// 黑名单token
        List<String> blacklistToken = Arrays.asList("禁止访问的token");
        Claims claims = jwtToken.getClaimByToken(authHeader);
        if (claims == null || JwtTokenConfig.isTokenExpired(claims.getExpiration()) || blacklistToken.contains(authHeader)) {
            throw new AuthenticationException("token 不可用");
        }
        String result = claims.getSubject();
// 根据用户id获取接口数据返回接口
        return result;
    }
}
