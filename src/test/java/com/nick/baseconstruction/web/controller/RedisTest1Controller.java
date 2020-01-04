package com.nick.baseconstruction.web.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest1Controller {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void method(){
        redisTemplate.opsForValue().set("name","wujianbo");
        String name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
}
