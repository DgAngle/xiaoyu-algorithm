package com.dgangle.array.array02_statistics;

import java.util.Arrays;

/**
 * 645. 错误的集合
 * AC
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/8/23 16:53
 */
public class Q645 {

    public static void main(String[] args) {
        // int[] nums = {1, 2, 2, 4};
        // int[] nums = {2, 2};
        // int[] nums = {2, 3, 2};
        int[] nums = {1, 2, 3, 4, 5, 6, 6};
        // int[] nums = {5, 3, 6, 1, 5, 4, 7, 8};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                res[0] = nums[i];
            }
            if (nums[i] - nums[i - 1] > 1) {
                res[1] = nums[i - 1] + 1;
            }
        }
        if (nums[0] != 1) res[1] = 1;
        if (res[1] < 1) res[1] = nums.length;
        return res;
    }

    public static int[] findErrorNums2(int[] nums) {
        int[] res = new int[nums.length];
        // int repeat = nums[0];
        int repeatIndex = 0;
        int lack = 0;
        int lackIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                // repeat = nums[i];
                repeatIndex = i;
            }
            if (nums[i] != nums[0] + i) {
                lack = nums[0] + i;
                lackIndex = i;
            }
        }

        System.out.println("repeatIndex = " + repeatIndex);
        System.out.println("lack = " + lack);
        System.out.println("lackIndex = " + lackIndex);

        for (int i = 0, k = 0; i < nums.length; i++) {
            if (repeatIndex == k) {
                i++;
            }
            if (lackIndex == k) {
                i--;
                res[i] = lack;
            } else {
                res[k] = nums[i];
            }
            k++;
        }
        return res;
    }


    /*
    集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
    给定一个数组 nums 代表了集合 S 发生错误后的结果。
    请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。

    示例 1：
    输入：nums = [1,2,2,4]
    输出：[2,3]

    示例 2：
    输入：nums = [1,1]
    输出：[1,2]

    提示：
    2 <= nums.length <= 104
    1 <= nums[i] <= 104

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/set-mismatch
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */

}
