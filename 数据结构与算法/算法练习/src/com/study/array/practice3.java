package com.study.array;

import java.util.Arrays;

/**
 * 两个数组的交集 II
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/7/5 15:48
 */
public class practice3 {
    /*
    给定两个数组，编写一个函数来计算它们的交集。

    示例 1：
        输入：nums1 = [1,2,2,1], nums2 = [2,2]
        输出：[2,2]
    示例 2:
        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        输出：[4,9]
    说明：
        输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
        我们可以不考虑输出结果的顺序。
    进阶：
        如果给定的数组已经排好序呢？你将如何优化你的算法？
        如果 nums1 的大小比 nums2 小很多，哪种方法更优？
        如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
    * */

    public static int[] intersect(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] max = length1 > length2 ? nums1 : nums2;
        int[] min = length1 > length2 ? nums2 : nums1;
        int[] temp = new int[min.length];
        int[] res = new int[min.length];
        int k = 0;
        for (int i = 0; i < min.length; i++) {
            for (int j = 0; j < max.length; j++) {
                if ((min[i] ^ max[j]) == 0 && j != temp[i]) { // 找到了这个数
                    // 存进temp中
                    temp[i] = j;
                    res[k] = min[i];
                    k++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersect = intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }
}
