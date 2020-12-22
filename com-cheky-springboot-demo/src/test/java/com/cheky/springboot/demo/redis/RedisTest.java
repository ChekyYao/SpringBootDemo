package com.cheky.springboot.demo.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author cheky
 * @date 2020-12-22
 */
@SpringBootTest
public class RedisTest {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testGetSetString(){
        redisTemplate.opsForValue().set("name","Cheky");
        var result = redisTemplate.opsForValue().get("name");
        assert result.equals("Cheky");
    }
}
