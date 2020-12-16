package com.cheky.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

/**
 * @author cheky
 * @date 2020-12-16
 */
@Controller
public class HelloThymeleafController {

    @RequestMapping("/hello_thymeleaf")
    public String hello(Model model) {
        model.addAttribute("name", "thymeleaf");
        return "HelloThymeleaf";
    }

}
