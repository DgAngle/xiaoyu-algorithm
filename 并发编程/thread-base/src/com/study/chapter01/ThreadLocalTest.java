package com.study.chapter01;

/**
 * ThreadLocal测试
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/10/14 9:58
 */
public class ThreadLocalTest {
    // 无法被子线程继承
    // public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    // 可以被子线程继承, 使用场景：① 子线程需要获取ThreadLocal中的用户登录信息, ② 一些中间件需要把统一的ID追踪的整个调用链路记录下来等等
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        // test2(); // 继承演示
    }

    /**
     * 演示 ThreadLocal 的继承方式
     */
    public static void test2() {
        // 归属于main线程
        threadLocal.set("Hello ThreadLocal!");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread: " + threadLocal.get());
            }
        });
        thread.start();

        System.out.println("main: " + threadLocal.get());
    }
}
