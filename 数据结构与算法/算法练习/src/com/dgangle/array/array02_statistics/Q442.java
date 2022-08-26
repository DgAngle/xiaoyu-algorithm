package com.dgangle.array.array02_statistics;

import java.util.*;

/**
 * 442. 数组中重复的数据
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/8/25 14:51
 */
public class Q442 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        // int[] nums = {1, 1, 2};
        // int[] nums = {1};
        System.out.println(Arrays.toString(findDuplicates(nums).toArray()));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] = -nums[num - 1];
            } else {
                list.add(num);
            }
        }
        return list;
    }

    public static List<Integer> findDuplicates_2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Integer num : map.keySet()) {
            if (map.get(num) > 1) list.add(num);
        }
        return list;
    }

    public static List<Integer> findDuplicates_1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] res = new int[nums.length + 1];
        for (int num : nums) {
            res[num]++;
        }
        for (int i = 1; i < res.length; i++) {
            if (res[i] > 1) list.add(i);
        }
        return list;
    }

    /*
    给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
    你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。

    示例 1：
    输入：nums = [4,3,2,7,8,2,3,1]
    输出：[2,3]

    示例 2：
    输入：nums = [1,1,2]
    输出：[1]

    示例 3：
    输入：nums = [1]
    输出：[]

    提示：
    n == nums.length
    1 <= n <= 105
    1 <= nums[i] <= n
    nums 中的每个元素出现 一次 或 两次

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/find-all-duplicates-in-an-array
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */
}
