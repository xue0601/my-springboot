package com.thread.demo;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author: xue0601
 * @Date: 2019-12-24 10:35
 */
public class CountDownLatchDemo {

    private static CountDownLatch countDownLatch = new CountDownLatch(4);

    /**
     * 线程池
     */
    private static ExecutorService executor = Executors.newFixedThreadPool(4);

    /**
     * 开启的线程数
     */
    private static int THREAD_COUNT = 4;


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_COUNT; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    try {
                        // 模拟业务逻辑的耗时
                        int timer = new Random().nextInt(5);
                        TimeUnit.SECONDS.sleep(timer);

                        System.out.printf("%s时完成磁盘的统计任务,耗费%d秒.\n", new Date().toString(), timer);
                        // 业务处理完成之后,计数器减一
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // 主线程一直被阻塞,直到countDownLatch的值为0
        countDownLatch.await();
        System.out.printf("%s时全部任务都完成,执行合并计算.\n", new Date().toString());
        executor.shutdown();
    }


}
