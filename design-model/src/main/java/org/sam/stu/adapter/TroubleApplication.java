package org.sam.stu.adapter;

public class TroubleApplication extends SpringBootAdapter {


    @Override
    public void webStarted() {
        System.out.println("复杂应用，web模块");
    }

    @Override
    public void testStarted() {
        System.out.println("复杂应用，test模块");
    }

    @Override
    public void aopStarted() {
        System.out.println("复杂应用，aop模块");
    }

    @Override
    public void mybatisStarted() {
        System.out.println("复杂应用，mybatis模块");
    }

    @Override
    public void jdbcStarted() {
        System.out.println("复杂应用，jdbc模块");
    }
}
