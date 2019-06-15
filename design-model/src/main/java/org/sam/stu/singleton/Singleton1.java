package org.sam.stu.singleton;

/**
 * 饿汉式单例模式
 * @author samphin
 * @date 2019-6-15 17:06:17
 */
public class Singleton1 {

    private static final Singleton1 instance = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance(){
        return instance;
    }
}
