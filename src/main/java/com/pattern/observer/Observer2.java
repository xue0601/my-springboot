package com.pattern.observer;

/**
 * @Author: xue0601
 * @Date: 2019/4/9 9:52
 */
public class Observer2 implements Observer {
    @Override
    public void update() {
        System.out.println("observe2 收到");
    }
}
