package com.study.chapter01;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/10/9 14:17
 */
public class JoinTest {
    public static void main(String[] args) {
        // try {
        //     test1();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        test2();

    }

    public static void test2() {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne 线程执行中！");
                // 死循环
                for (int i = 0; ; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            }
        });
        Thread threadCurrent = Thread.currentThread();
        System.out.println("threadOne Name = " + threadOne.getName());
        System.out.println("threadCurrent Name = " + threadCurrent.getName());

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadTwo 线程执行中！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadCurrent.interrupt(); // 中断主线程
            }
        });

        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
        } catch (InterruptedException e) {
            // e.printStackTrace();
            System.out.println("main thread : " + e);
        }
    }

    /**
     * join：等待所属线程结束后再往下执行
     *
     * @throws InterruptedException
     */
    public static void test1() throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadOne 线程执行结束！");
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadTwo 线程执行结束！");
            }
        });

        threadOne.start();
        threadTwo.start();
        System.out.println("等待所有的子线程结束！");
        threadOne.join();
        System.out.println("所有的子线程结束！");
        threadTwo.join();
    }
}
