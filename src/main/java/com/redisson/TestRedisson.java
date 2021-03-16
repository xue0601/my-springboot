package com.redisson;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xue0601
 * @Date: 2019-12-26 11:22
 */
@Slf4j
@RestController("redisson")
public class TestRedisson {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping(value = "getRedisson")
    public void getRedisson(String recordId){
        System.out.println("进入了Redisson");
        RLock lock = redissonClient.getLock(recordId);
        try {
            boolean bs = lock.tryLock(5, 6, TimeUnit.SECONDS);
            if (bs) {
                // 业务代码
                log.info("进入业务代码: " + recordId);

                lock.unlock();
            } else {
                Thread.sleep(300);
            }
        } catch (Exception e) {
            log.error("1234", e);
            lock.unlock();
        }
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < ; i++) {
//
//        }
//    }

}
