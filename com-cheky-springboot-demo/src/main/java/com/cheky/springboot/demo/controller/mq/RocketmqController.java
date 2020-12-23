package com.cheky.springboot.demo.controller.mq;

import com.cheky.springboot.demo.dto.UserDTO;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mq: producer
 *
 * @author cheky
 * @date
 */
@RestController
@RequestMapping("rocketmq")
public class RocketmqController {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @PostMapping
    public ResponseEntity insertUser(@RequestBody UserDTO user) {
        rocketMQTemplate.convertAndSend("mygroup2",user.toString());
        System.out.println("Send mq: " + user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
