package com.cheky.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloJDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/hello/jdbc")
    public Map<String, Object> map(){
        var list = jdbcTemplate.queryForList("select * from testtable");
        return list.get(0);
    }
}
