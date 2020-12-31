package com.cheky.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Reference : https://www.cnblogs.com/steveshao/archive/2019/10/10/11649537.html
 *
 * @author Cheuk
 * @date 2020-12-31
 */
@Slf4j
@RestController
@RequestMapping("slf4j")
public class Slf4jController {

    @GetMapping
    public String generateLog(){
        //日志的级别
        //由低到高 trace < debug < info < warn < error
        //可以调整输出的日志级别；日志就只会在这个级别及其以后的高级别生效
        log.trace("这个是trace日志...");
        log.debug("这个是debug日志...");

        //Spring boot 默认给我们使用的是Info级别，即 没指定级别的就用 SpringBoot默认规定的级别：root级别
        log.info("这个是info日志...");
        log.warn("这个是warn日志...");
        log.error("这个是error日志...");
        return "generate log successfully!";
    }
}
