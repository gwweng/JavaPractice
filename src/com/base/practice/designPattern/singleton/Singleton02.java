package com.base.practice.designPattern.singleton;

/**
 * 单例模式
 * 懒汉式
 * 不会一创建类就实例化，延迟到第一次引用的时候
 */
public class Singleton02 {
    private Singleton02(){

    }

    // 防止指令重排
    private static volatile Singleton02 instance;
    public Singleton02 getInstance(){
        if(instance == null){
            synchronized (this){
                if(instance == null){
                    instance = new Singleton02();
                }
            }
        }
        return instance;
    }
}
