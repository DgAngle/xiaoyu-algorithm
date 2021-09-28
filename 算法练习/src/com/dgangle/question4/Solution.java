package com.dgangle.question4;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * @Author gqshuang
 * @Date 2021/6/1 10:23
 * @Version 1.0
 */
public class Solution {
    /*
        给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数\
        示例 1：
            输入：nums1 = [1,3], nums2 = [2]
            输出：2.00000
            解释：合并数组 = [1,2,3] ，中位数 2
        示例 2：
            输入：nums1 = [1,2], nums2 = [3,4]
            输出：2.50000
            解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
        示例 3：
            输入：nums1 = [0,0], nums2 = [0,0]
            输出：0.00000
        示例 4：
            输入：nums1 = [], nums2 = [1]
            输出：1.00000
        示例 5：
            输入：nums1 = [2], nums2 = []
            输出：2.00000

       提示：
            - nums1.length == m
            - nums2.length == n
            - 0 <= m <= 1000
            - 0 <= n <= 1000
            - 1 <= m + n <= 2000
            - -106 <= nums1[i], nums2[i] <= 106

        进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 执行结果：通过
     * 执行用时：49 ms , 在所有 Java 提交中击败了 5.13% 的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了 75.84% 的用户
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1 = nums1.length;
        int num2 = nums2.length;
        int sum = num1 + num2;
        int fontNum = sum % 2 == 0 ? sum / 2 - 1 : sum / 2;
        int afterNum = sum / 2;
        int[] sumArr = new int[num1 + num2];
        // 其中一个是空数组
        if (num1 == 0) {
            sumArr = nums2;
            return (sumArr[fontNum] + sumArr[afterNum]) / 2.0;
        } else if (num2 == 0) {
            sumArr = nums1;
            return (sumArr[fontNum] + sumArr[afterNum]) / 2.0;
        }
        // 如果都不是空数组
        LinkedList<Integer> linked = new LinkedList();
        // 数组1赋值
        for (int i = 0; i < num1; i++) {
            linked.add(nums1[i]);
        }
        // 数组2比较
        int k = 0; // 记录上一次插入的位置
        for (int i = 0; i < num2; i++) {
            for (int j = k; j < linked.size(); j++) {
                if (nums2[i] < linked.get(j)) {
                    break;
                }
                k++;
            }
            linked.add(k, nums2[i]);
        }
        for (int i = 0; i < linked.size(); i++) {
            sumArr[i] = linked.get(i);
        }

        // System.out.println(Arrays.toString(sumArr));
        return (sumArr[fontNum] + sumArr[afterNum]) / 2.0;
    }

    /**
     * 负数无法正确排序
     */
    public static double findMedianSortedArrays_old(int[] nums1, int[] nums2) {
        LinkedList<Integer> linked = new LinkedList();
        int num1 = nums1.length;
        int num2 = nums2.length;
        int sum = num1 + num2;
        int fontNum = sum % 2 == 0 ? sum / 2 - 1 : sum / 2;
        int afterNum = sum / 2;
        int[] sumArr = new int[num1 + num2];
        for (int i = 0; i < num1; i++) {
            linked.add(nums1[i]);
        }
        if (linked.size() > 0) {
            for (int i = num1, k = 0; i < sum; i++, k++) {
                int tempIndex = i;
                int temp = linked.get(i - 1);
                while (temp > nums2[k] && tempIndex > 0) {
                    temp = linked.get(--tempIndex);
                }
                linked.add(tempIndex, nums2[k]);
            }
            for (int i = 0; i < sum; i++) {
                sumArr[i] = linked.get(i);
            }
        } else {
            sumArr = nums2;
        }
        System.out.println(Arrays.toString(sumArr));
        return (sumArr[fontNum] + sumArr[afterNum]) / 2.0;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 3}, nums2 = {2};
//        int[] nums1 = {1, 2}, nums2 = {3, 4};
//        int[] nums1 = {}, nums2 = {1};
//        int[] nums1 = {1}, nums2 = {};
//        int[] nums1 = {3}, nums2 = {-2, -1};
//        int[] nums1 = {1, 3}, nums2 = {2};
        int[] nums1 = {}, nums2 = {1, 2, 3, 4};
        double mid = findMedianSortedArrays(nums1, nums2);
        System.out.println("计算结果：" + mid);
    }
}
