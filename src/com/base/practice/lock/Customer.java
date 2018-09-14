package com.base.practice.lock;

public class Customer implements Runnable {

    private volatile  Resource2 resource;
    public Customer(Resource2 resource){
        this.resource = resource;
    }


    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.remove();
        }
    }
}
