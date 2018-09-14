package com.base.practice.designPattern.singleton;

/**
 * 单例模式
 * 饿汉式
 * 以最快的方式获取到对象实例,使用内部类的方式可以防止某些类加载多次就实例化多次
 */
public class Singleton01 {
    // 非内部类
    //public static Singleton01 instance = new Singleton01();

    // 内部类实现
    public static class SingletonHolder {
        private final static Singleton01 INSTANCE = new Singleton01();
    }
    private Singleton01(){
        System.out.println("实例化完成");
    }


    public static Singleton01 getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        Singleton01.getInstance();
    }
}
