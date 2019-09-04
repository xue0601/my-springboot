package com.pattern.decorator;

/**
 * 装饰类2
 * @Author: xue0601
 * @Date: 2019/3/18 9:58
 */
public class Decorator2 implements Sourceable {

    private Sourceable sourceable;

    public Decorator2(Sourceable sourceable) {
        super();
        this.sourceable = sourceable;
    }

    @Override
    public void method() {
        sourceable.method();
        System.out.println("装饰方法2");
    }
}
