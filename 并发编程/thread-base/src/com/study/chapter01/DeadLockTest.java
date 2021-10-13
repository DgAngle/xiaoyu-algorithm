package com.study.chapter01;

/**
 * 死锁与避免死锁
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/10/13 9:25
 */
public class DeadLockTest {
    private static Object resource1 = new Object(); // 资源1
    private static Object resource2 = new Object(); // 资源2

    public static void main(String[] args) {
        // test1(); // 死锁
        test2(); // 避免死锁
    }

    /**
     * 死锁演示
     */
    public static void test1() {
        // 线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + ": 线程A获取了资源2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + ": 线程A等待资源1");
                    synchronized (resource1) {
                        System.out.println(Thread.currentThread() + ": 线程A获取了资源1");
                    }
                }
            }
        });

        // 线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + ": 线程B获取了资源1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + ": 线程B等待资源2");
                    synchronized (resource2) {
                        System.out.println(Thread.currentThread() + ": 线程B获取了资源2");
                    }
                }
            }
        });

        // 启动线程
        threadA.start();
        threadB.start();
    }

    /**
     * 避免死锁演示：改变test1中线程A获取资源的顺序, 跟线程B保持一致
     */
    public static void test2() {
        // 线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + ": 线程A获取了资源1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + ": 线程A等待资源2");
                    synchronized (resource2) {
                        System.out.println(Thread.currentThread() + ": 线程A获取了资源2");
                    }
                }
            }
        });

        // 线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + ": 线程B获取了资源1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + ": 线程B等待资源2");
                    synchronized (resource2) {
                        System.out.println(Thread.currentThread() + ": 线程B获取了资源2");
                    }
                }
            }
        });

        // 启动线程
        threadA.start();
        threadB.start();
    }
}
