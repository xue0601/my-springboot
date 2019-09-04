package com.ylyw;

import com.thread.demo.ExtendsThread;
import com.thread.demo.ImplementCallable;
import com.thread.demo.ImplementRunnable;
import com.thread.demo.ThreadPool;
import org.elasticsearch.search.aggregations.metrics.ParsedSingleValueNumericMetricsAggregation;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Author: xue0601
 * @Date: 2019/5/8 9:50
 */
@SpringBootTest
public class ThreadTest {

    @Test
    public void extendsThreadTest(){
        Thread thread = new ExtendsThread();
        thread.start();
    }

    @Test
    public void ImplementRunnableTest(){
        ImplementRunnable implementRunnable = new ImplementRunnable();
        new Thread(implementRunnable).start();
        new Thread(implementRunnable).start();
    }

    @Test
    public void ImplementCallableTest(){
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new ImplementCallable());
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        Integer sum = null;
        try {
            sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void threadPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ThreadPool threadPool = new ThreadPool();
        for (int i = 0; i < 5 ; i++) {
            executorService.submit(threadPool);
        }
        executorService.shutdown();
    }

}
