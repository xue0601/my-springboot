package com.pattern.decorator;

/**
 * @Author: xue0601
 * @Date: 2019/3/18 9:52
 * 被装饰类
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("原始方法");
    }
}
