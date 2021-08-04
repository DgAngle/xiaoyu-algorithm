package com.test;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/6/16 10:50
 */
public class Test1 {


    public static void main(String[] args) {

        int[] nums = {-336, 513, -560, -481, -174, 101, -997, 40, -527, -784, -283, -336, 513, -560, -481, -174, 101, -997, 40, -527, -784, -283, 354};
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        System.out.println(num);
    }
}
