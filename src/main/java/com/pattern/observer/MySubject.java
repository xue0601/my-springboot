package com.pattern.observer;

/**
 * @Author: xue0601
 * @Date: 2019/4/9 9:59
 */
public class MySubject extends AbstractSubject {
    @Override
    public void operation() {
        System.out.println("更新自己");
        notifyObserver();
    }
}
