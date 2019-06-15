package org.sam.stu.singleton;

/**
 * 懒汉式单例模式，懒汉模式在使用时，容易引起不同步问题，所以应该创建
 * @author samphin
 * @date 2019-6-15 17:06:17
 */
public class Singleton2 {

    private static Singleton2 instance = null;

    private Singleton2(){}

    /**
     * 同步代码块执行效率更高，推荐使用
     * @return
     */
    public static Singleton2 getInstance(){
        if(null == instance){
            synchronized(Singleton2.class){
                instance = new Singleton2();
            }
        }
        return instance;
    }

    /**
     * 方法级同步
     * @return
     */
    public static synchronized Singleton2 getInstance1(){
        if(null == instance){
            return new Singleton2();
        }
        return null;
    }


}
