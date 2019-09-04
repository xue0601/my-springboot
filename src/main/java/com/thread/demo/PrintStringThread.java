package com.thread.demo;

import java.util.List;

/**
 * @program: my-springboot
 * @description:
 * @author: Xue0601
 * @create: 2018-11-15 11:47
 **/
public class PrintStringThread implements Runnable {

    private int num;
    private List <String> stringList;
    private int threadNum;

    public PrintStringThread(int num, List <String> stringList, int threadNum) {
        this.num = num;
        this.stringList = stringList;
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        int length = 0;
        for (String str : stringList) {
            if (length % threadNum == num) {
                System.out.println("线程编号：" + num + "，字符串：" + str);
            }
            length++;
        }
    }

}
