package com.thread.demo;

/**
 * @Author: xue0601
 * @Date: 2019/5/8 11:01
 */
public class ThreadPool implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
