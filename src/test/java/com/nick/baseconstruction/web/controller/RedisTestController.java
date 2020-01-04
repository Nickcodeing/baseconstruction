package com.nick.baseconstruction.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate){
        RedisSerializer redisSerializer =  new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setValueSerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        redisTemplate.setHashValueSerializer(redisSerializer);
        this.redisTemplate = redisTemplate;
    }

    @Test
    public void method(){
        redisTemplate.opsForValue().set("key2","value2");
        String result = redisTemplate.opsForValue().get("key2").toString();
        System.out.println(result);
    }

    @Test
    public void method2(){
        Boolean key1 = redisTemplate.delete("key1");
        System.out.println(key1);
    }
}
