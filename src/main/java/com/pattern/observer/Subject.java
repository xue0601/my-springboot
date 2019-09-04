package com.pattern.observer;

/**
 * @Author: xue0601
 * @Date: 2019/4/9 9:53
 */
public interface Subject {

    //添加观察者
    public void add(Observer observer);
    //删除观察者
    public void del(Observer observer);
    //通知所有观察者
    public void notifyObserver();
    //自身的操作
    public void operation();


}
