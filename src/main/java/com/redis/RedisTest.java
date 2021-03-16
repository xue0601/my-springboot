package com.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xue0601
 * @Date: 2019-11-18 14:43
 */
@RestController
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public void zsetTest(){
        //新增
        redisTemplate.opsForZSet().add("key","value",5);
        //删除
        redisTemplate.opsForZSet().remove("key","value");
        //修改score
        redisTemplate.opsForZSet().incrementScore("key","value",999);
        //获取集合中对应的score
        redisTemplate.opsForZSet().score("key","value");
        //获取value在集合中的排名
        redisTemplate.opsForZSet().rank("key","value");
        //获取集合的长度
        redisTemplate.opsForZSet().zCard("key");
        //查询集合中指定顺序的值  key  start  end   返回有序集合 score小的在前
        redisTemplate.opsForZSet().range("key",0,-1);
        //查询集合中指定顺序的值和score  key start end
        redisTemplate.opsForZSet().rangeWithScores("key",0,-1);

    }

}
