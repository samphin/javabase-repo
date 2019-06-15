package org.sam.stu;

/**
 * 通过内部类形式，创建单例对象
 */
public class Singleton {

    private Singleton(){}

    public static Singleton getInstance(){
       return SingletonInner.INSTANCE;
    }

    public static class SingletonInner{
        private final static Singleton INSTANCE = new Singleton();
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}
