package com.study.array;

import java.util.Arrays;

/**
 * 旋转数组
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/6/18 16:44
 */
public class practice2 {
    /**
     * 失败, 未考虑数组长度小于 k 的情况
     *
     * @param nums 原数组
     * @param k    右移的个数
     */

    public static void rotate1(int[] nums, int k) {
        int[] arr = new int[nums.length];
        int j = 0;
        for (int i = (nums.length - k); i < nums.length; i++) {
            arr[j++] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            arr[j++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 参考题解
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int temp[] = new int[length];
        //把原数组值放到一个临时数组中，
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        //然后在把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        // int[] nums = {-1};
        rotate(nums, 3);
    }
}
