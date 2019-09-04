package com.pattern.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Author: xue0601
 * @Date: 2019/4/9 9:56
 */
public abstract class AbstractSubject implements Subject {

    private Vector<Observer> vector = new Vector<>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObserver() {
        Enumeration<Observer> enumo = vector.elements();
        while (enumo.hasMoreElements()){
            enumo.nextElement().update();
        }
    }
}
