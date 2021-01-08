package com.cheky.springboot.demo.controller.captcha;

import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用图形验证码
 *
 * @author Cheky
 * @date 2020-12-15
 *
 * https://github.com/whvcse/EasyCaptcha
 */
@RestController
@RequestMapping("captcha")
public class CaptchaController {

    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.out(request, response);
    }
}
