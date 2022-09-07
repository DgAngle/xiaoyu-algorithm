package com.dgangle.array.array01_Iterable;

/**
 * 485. 最大连续 1 的个数
 * AC
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/8/11 14:17
 */
public class Q485 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 0, 1};
        // int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    // 找到最大连续 1 的个数
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                if (temp > max) max = temp;
                temp = 0;
            } else {
                temp++;
            }
        }
        if (temp > max) max = temp;
        return max;
    }


    /*
    给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。

    示例 1：

    输入：nums = [1,1,0,1,1,1]
    输出：3
    解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
    示例 2:

    输入：nums = [1,0,1,1,0,1]
    输出：2

    提示：

    1 <= nums.length <= 105
    nums[i] 不是 0 就是 1.

    来源：力扣（LeetCode）
    https://leetcode.cn/problems/max-consecutive-ones
    */
}
