package com.base.practice.lock;

/**
 * 生产者
 */
public class Producer implements Runnable{
    private volatile Resource2 resource;
    public Producer(Resource2 resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        // 不断生产资源
        while (true){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.add();
        }
    }
}
