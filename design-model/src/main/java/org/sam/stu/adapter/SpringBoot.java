package org.sam.stu.adapter;

/**
 * 以springboot框架包含的started举例，接口类适配器模式
 * @author samphin
 * @date 2019-6-15 16:51:59
 */
public interface SpringBoot {

    void webStarted();

    void testStarted();

    void aopStarted();

    void mybatisStarted();

    void jdbcStarted();
}
