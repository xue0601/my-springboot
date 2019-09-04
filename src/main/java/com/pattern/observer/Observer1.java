package com.pattern.observer;

/**
 * @Author: xue0601
 * @Date: 2019/4/9 9:52
 */
public class Observer1 implements Observer {
    @Override
    public void update() {
        System.out.println("observer1 收到");
    }
}
