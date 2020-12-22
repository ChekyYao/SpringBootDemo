package com.cheky.springboot.demo.redis;

import com.cheky.springboot.demo.service.RedissonService;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author cheky
 * @date 2020-12-22
 */
@SpringBootTest
public class RedissonTest {
    @Autowired
    RedissonService redissonService;

    @Test
    public void testLockUnLock(){
        RLock lock = redissonService.getRLock("name");
        try {
            boolean bs = lock.tryLock(5, 6, TimeUnit.SECONDS);
            if (bs) {
                lock.unlock();
            } else {
                Thread.sleep(300);
            }
        } catch (Exception e) {
            lock.unlock();
        }
    }
}
