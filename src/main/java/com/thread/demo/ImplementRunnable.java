package com.thread.demo;

/**
 * @Author: xue0601
 * @Date: 2019/5/8 10:00
 */
public class ImplementRunnable implements Runnable {

    private int tickte = 1120;

    @Override
    public void run() {
        while (true){
            if (tickte > 0){
                System.out.println(Thread.currentThread().getName()+"出售票"+tickte--);
            }else {
                System.exit(0);
            }
        }
    }
}
