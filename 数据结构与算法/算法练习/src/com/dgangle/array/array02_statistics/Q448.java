package com.dgangle.array.array02_statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * AC
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/8/24 16:49
 */
public class Q448 {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        // int[] nums = {1, 1};

        System.out.println(Arrays.toString(findDisappearedNumbers(nums).toArray()));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int max = nums.length;
        int[] maxArr = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            maxArr[nums[i - 1]]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            if (maxArr[i] == 0) list.add(i);
        }
        return list;
    }

    /*
    给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。

    示例 1：
    输入：nums = [4,3,2,7,8,2,3,1]
    输出：[5,6]

    示例 2：
    输入：nums = [1,1]
    输出：[2]

    提示：
    n == nums.length
    1 <= n <= 105
    1 <= nums[i] <= n
    进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */
}
