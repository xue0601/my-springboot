package com.thread.demo;

import java.util.concurrent.Callable;

/**
 * @Author: xue0601
 * @Date: 2019/5/8 10:22
 */
public class ImplementCallable implements Callable {

    @Override
    public Integer call(){
        System.out.println("当前线程:"+Thread.currentThread().getName());
        int sum = 0;
        for (int i = 0; i < 10000 ; i++) {
            sum+=i;
        }
        return sum;
    }
}
