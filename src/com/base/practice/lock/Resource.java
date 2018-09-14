package com.base.practice.lock;

/**
 * 公共资源类.
 * 生产者消费者注意点
 * 1.如果缓冲区已满，则生产者阻塞
 * 2.如果缓冲区为空，则消费者阻塞
 * 使用synchronized,wait,nofigyAll实现
 */
public class Resource {
    private static int count = 5;
    // 仓库允许存放的资源数量
    private static int size = 10;

    /**
     * 从资源中取走资源
     */
    public synchronized void remove(){
        if(count > 0){
            count --;
            System.out.println("消费者取走资源，当前线程为"+Thread.currentThread().getName()+"，还剩下"+ count+"个资源");
            // 通知生产者开始生产
            notifyAll();
        }else{
            //资源不足，消费者阻塞
            try {
                wait();
                System.out.println("资源不足，等待生产者生产");
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    /**
     * 生产资源
     */
    public synchronized void add(){
        if(count > size){
            // 资源过多，生产者阻塞
            try {
                wait();
                System.out.println("资源过多，生产者阻塞等待消费者消费");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            count ++;
            // 通知消费者消费
            notifyAll();
            System.out.println("生产者生产资源，当前线程为"+Thread.currentThread().getName()+",还剩下"+count + "个资源");
        }
    }

}
