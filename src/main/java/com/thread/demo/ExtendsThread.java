package com.thread.demo;

/**
 * @Author: xue0601
 * @Date: 2019/5/8 9:46
 */
public class ExtendsThread extends Thread {

    private int tickte = 20;

    @Override
    public void run() {
        while (true){
            if (tickte>0){
                System.out.println(Thread.currentThread().getName()+"出售票"+ tickte--);
            }else {
                System.exit(0);
            }
        }
    }

}
