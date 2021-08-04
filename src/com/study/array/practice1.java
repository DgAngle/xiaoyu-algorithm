package com.study.array;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/6/15 16:50
 */
public class practice1 {
    /**
     * 异或
     * 1 ^ 1 = 0;
     * 1 ^ 0 = 1;
     * 0 ^ 1 = 1;
     * 0 ^ 0 = 0;
     * 又 a ^ b ^ c = a ^ c ^ b, 所以将数组中的数挨个异或，最后剩下的数就是只出现一次的数
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 1, 2};
//        int[] nums = {4, 1, 2, 1, 2};
//        int[] nums = {-1};
        int[] nums = {-336, 513, -560, -481, -174, 101, -997, 40, -527, -784, -283, -336, 513, -560, -481, -174, 101, -997, 40, -527, -784, -283, 354};

        System.out.println(singleNumber(nums));
    }
}
