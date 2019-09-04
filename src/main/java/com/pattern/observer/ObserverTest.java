package com.pattern.observer;

/**
 * @Author: xue0601
 * @Date: 2019/4/9 10:00
 */
public class ObserverTest {

    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());
        sub.operation();
    }

}
