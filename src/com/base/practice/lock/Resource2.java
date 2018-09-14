package com.base.practice.lock;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 使用阻塞队列实现
 */
public class Resource2 {
    private BlockingQueue resource = new LinkedBlockingDeque(10);

    public void add(){
        try {
            resource.put(1);
            System.out.println("生产者生产资源，当前线程为"+Thread.currentThread().getName()+",个数为"+resource.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void remove(){
        try {
            resource.take();
            System.out.println("消费者消费资源，当前线程为"+Thread.currentThread().getName()+",个数为"+resource.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
