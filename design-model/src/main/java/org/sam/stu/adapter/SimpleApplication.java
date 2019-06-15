package org.sam.stu.adapter;

public class SimpleApplication extends SpringBootAdapter {

    @Override
    public void webStarted() {
        System.out.println("简单应用，web模块");
    }

    @Override
    public void testStarted() {
        System.out.println("简单应用，test模块");
    }
}
