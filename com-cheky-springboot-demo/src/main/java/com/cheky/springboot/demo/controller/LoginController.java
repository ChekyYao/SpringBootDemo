package com.cheky.springboot.demo.controller;

import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 使用图形验证码
 *
 * @author Cheky
 * @date 2020-12-15
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(String username,String password,String verCode, HttpServletRequest request){
        if (!CaptchaUtil.ver(verCode, request)) {
            CaptchaUtil.clear(request);  // 清除session中的验证码
            return "验证码不正确";
        }
        return "验证码正确";
    }
}
