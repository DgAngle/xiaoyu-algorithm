package com.dgangle.array.array01_Iterable;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/8/17 16:06
 */
public class Q628 {

    public static void main(String[] args) {
        // int[] nums = {1, 2, 3};
        // int[] nums = {1, 2, 3, 4};
        // int[] nums = {-1, -2, -3};
        // int[] nums = {-100, -98, -1, 2, 3, 4};
        // int[] nums = {-100, -98, 0, 0, 3, 4};
        // int[] nums = {-100, -2, -3, 1};
        int[] nums = {-100, -2, -3, 1, -10};
        // int[] nums = {-8, -7, -2, 10, 20};
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        // System.out.println(Arrays.toString(nums));
        return Math.max(nums[0] * nums[1] * nums[length - 1], nums[length - 3] * nums[length - 2] * nums[length - 1]);
    }

    public static int maximumProduct_my(int[] nums) {
        if (nums.length == 3) return nums[0] * nums[1] * nums[2];

        Integer a = null, b = null, c = null; // 最大的三个正数, c最大
        Integer d = null, e = null, f = null; // 最小的三个负数, f最大

        int ka = 0; // 正数数量
        int kd = 0; // 负数数量
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                ka++;
                // 最大的三个正数
                if (c == null || nums[i] >= c) {
                    a = b;
                    b = c;
                    c = nums[i];
                } else if (nums[i] < c && (b == null || nums[i] >= b)) {
                    a = b;
                    b = nums[i];
                } else if (b != null && nums[i] < b && (a == null || nums[i] >= a)) {
                    a = nums[i];
                }
            } else {
                kd++;
                // 最小的三个负数
                if (d == null || nums[i] < d) {
                    f = e;
                    e = d;
                    d = nums[i];
                } else if (nums[i] > d && (e == null || nums[i] < e)) {
                    f = e;
                    e = nums[i];
                } else if (e != null && nums[i] > e && (f == null || nums[i] < f)) {
                    f = nums[i];
                }
            }
        }

        System.out.println("a,b,c = " + a + "," + b + "," + c);
        System.out.println("d,e,f = " + d + "," + e + "," + f);

        // 三负
        if (ka <= 0) return d * e * f;
        // 三正
        if (kd <= 0 || e == null) return a * b * c;
        // 1正二负
        if (b == null && c != null && kd >= 2) return c * d * e;
        //

        return a * b * c > c * d * e ? a * b * c : c * d * e;
    }

    /*
    给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

    示例 1：
    输入：nums = [1,2,3]
    输出：6

    示例 2：
    输入：nums = [1,2,3,4]
    输出：24

    示例 3：
    输入：nums = [-1,-2,-3]
    输出：-6

    提示：
    3 <= nums.length <=104
    -1000 <= nums[i] <= 1000
    通过次数100,918提交次数192,689

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/maximum-product-of-three-numbers
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */
}
