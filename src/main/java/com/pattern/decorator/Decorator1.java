package com.pattern.decorator;

/**
 * 装饰类1
 * @Author: xue0601
 * @Date: 2019/3/18 9:53
 */
public class Decorator1 implements Sourceable {

    private Sourceable sourceable;

    public Decorator1(Sourceable sourceable) {
        super();
        this.sourceable = sourceable;
    }

    @Override
    public void method() {
        sourceable.method();
        System.out.println("开始");
        System.out.println("装饰方法1");
        System.out.println("结束");
    }
}
