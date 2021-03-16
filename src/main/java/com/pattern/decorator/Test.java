package com.pattern.decorator;

/**
 * 装饰者模式
 * @Author: xue0601
 * @Date: 2019/3/18 9:56
 */
public class Test {

    public static void main(String[] args) {
        Sourceable sourceable = new Source();
        Sourceable obj = new Decorator1(sourceable);
        Sourceable obj2 = new Decorator2(obj);
        obj2.method();
    }

}
