package com.study.chapter01;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * CAS 工具类 Unsafe
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/10/15 10:23
 */
public class UnsafeTest {
    // 获取Unsafe的实例, 运行 main 报错
    // static final Unsafe unsafe = Unsafe.getUnsafe();
    // 在static代码块通过反射获取, 运行 main 输出 true
    static final Unsafe unsafe;
    // 记录变量state的偏移量
    static final long stateOffset;
    // 变量
    private volatile long state = 0;

    static {
        try {
            // 反射获取Unsafe的成员变量theUnsafe
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            // 设置为可存取
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);

            // 获取state变量的偏移值
            stateOffset = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        UnsafeTest test = new UnsafeTest();
        System.out.println(test.state);
        boolean flag = unsafe.compareAndSwapLong(test, stateOffset, 0, 1);
        System.out.println(test.state);
        System.out.println(flag);
    }

}
