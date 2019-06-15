package org.sam.stu.singleton;

/**
 * 通过内部类形式，创建单例对象
 * @author samphin
 * @date 2019-6-15 17:04:33
 */
public class Singleton {

    private Singleton(){}

    public static Singleton getInstance(){
       return SingletonInner.INSTANCE;
    }

    public static class SingletonInner{
        private static Singleton INSTANCE = new Singleton();
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}
