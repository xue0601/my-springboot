package com.thread.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: my-springboot
 * @description:
 * @author: Xue0601
 * @create: 2018-11-15 11:21
 **/
public class ThreadTest {


    public static void main(String[] args) {
        List<String> stringList = new ArrayList <String>();
        for (int i = 0; i <100 ; i++) {
            stringList.add("String"+i);

        }
        int threadNum = stringList.size()<5? stringList.size():5;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,threadNum,300, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue <Runnable>(3),new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i <threadNum ; i++) {
            threadPoolExecutor.execute(new PrintStringThread(i,stringList,threadNum));
        }
        threadPoolExecutor.shutdown();

        //实现runnable测试
//        ImplementRunnable implementRunnable = new ImplementRunnable();
//        new Thread(implementRunnable).start();
//        new Thread(implementRunnable).start();
//        new Thread(implementRunnable).start();

        //继承Thread测试
//        Thread thread = new ExtendsThread();
//        Thread thread1 = new ExtendsThread();
//        thread1.start();
//        thread.start();
    }

}
