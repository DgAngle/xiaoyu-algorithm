package com.study.chapter01;

/**
 * 章节一：多线程练习
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/9/28 9:57
 */
public class ThreadTest {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I'm MyThread, i'm running!");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
