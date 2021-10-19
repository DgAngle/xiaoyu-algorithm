package com.study.chapter01;

/**
 * 指令重排序
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/10/19 9:47
 */
public class ThreadOrderTest {

    /* 读线程 */
    public static class Read extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (ready) {
                    System.out.println(num + num);
                }
                System.out.println("Read 读线程!");
            }
        }
    }

    /* 写线程 */
    public static class Write extends Thread {
        @Override
        public void run() {
            num = 2;
            ready = true;

            System.out.println("Write 写线程执行结束!");
        }
    }

    // 正常变量, 多线程存在重排序问题, 导致输出结果不一定是4, 也可能是0
    // private static int num = 0;
    // private static boolean ready = false;

    // 优化：使用volatile修饰ready变量, 避免重排序和内存可见性问题
    private static int num = 0;
    private static volatile boolean ready = false;

    public static void main(String[] args) throws InterruptedException {
        Read read = new Read();
        read.start();
        Write write = new Write();
        write.start();
        Thread.sleep(10);
        read.interrupt();
        System.out.println("主线程执行结束!");
    }
}
