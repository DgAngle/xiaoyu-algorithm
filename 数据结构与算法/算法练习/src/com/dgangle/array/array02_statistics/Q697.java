package com.dgangle.array.array02_statistics;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/8/24 10:13
 */
public class Q697 {
    public static void main(String[] args) {
        // int[] nums = {1, 2, 2, 3, 1};
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        System.out.println(findShortestSubArray(nums));
    }


    public static int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        // 度数, 起始位置, 结束位置
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++; // 计算度数
                map.get(nums[i])[2] = i; // 结束位置
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }

        // 度, 度的最小长度
        int maxNum = 0, minLength = 0;
        for (int num : map.keySet()) {
            int[] arr = map.get(num);
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLength = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                if (arr[2] - arr[1] + 1 < minLength) minLength = arr[2] - arr[1] + 1;
            }
        }
        return minLength;
    }

    public static int findShortestSubArray_my(int[] nums) {
        // 度
        int[][] du = new int[2][nums.length];
        // 找出重复次数最大的数(一个或者多个)
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (nums[i] == du[0][j]) {
                    du[1][j]++;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                du[0][k] = nums[i];
                du[1][k] = 1;
                k++;
            }
        }

        // 第一个度 及 对应度数
        int maxAppearIndex = 0, maxAppear = du[0][0], maxAppearNum = du[1][0];
        for (int i = 0; i < k; i++) {
            if (du[1][i] > maxAppearNum) {
                maxAppear = du[0][i];
                maxAppearNum = du[1][i];
                maxAppearIndex = i;
            }
        }

        // 度的数目
        int n = 0;
        for (int i = 0; i < k; i++) {
            if (du[1][i] == maxAppearNum) n++;
        }

        // 获取度
        int[] maxNum = new int[n];
        int m = 0;
        for (int i = 0; i < k; i++) {
            if (du[1][i] == maxAppearNum) maxNum[m++] = du[0][i];
        }

        // 最短连续子数组
        // int[] arrLength = new int[n];
        int minLength = 0;
        for (int i = 0; i < n; i++) {
            int[] length = new int[maxAppearNum];
            int index = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == maxNum[i]) length[index++] = j;
            }
            int tempLength = length[maxAppearNum - 1] - length[0] + 1;
            if (minLength == 0) minLength = tempLength;
            else if (tempLength < minLength) minLength = tempLength;
        }

        // System.out.println(minLength);

        // System.out.println(Arrays.toString(maxNum));

        // System.out.println("n = " + n);

        // System.out.println("maxAppear = " + maxAppear);
        // System.out.println("maxAppearNum = " + maxAppearNum);
        // System.out.println("maxAppearIndex = " + maxAppearIndex);

        // System.out.println(Arrays.toString(du[0]));
        // System.out.println(Arrays.toString(du[1]));
        return minLength;
    }

    /*
    给定一个非空且只包含非负数的整数数组nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
    你的任务是在 nums 中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
    
    示例 1：
    输入：nums = [1,2,2,3,1]
    输出：2
    解释：
    输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
    连续子数组里面拥有相同度的有如下所示：
    [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
    最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。

    示例 2：
    输入：nums = [1,2,2,3,1,4,2]
    输出：6
    解释：
    数组的度是 3 ，因为元素 2 重复出现 3 次。
    所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。

    提示：
    nums.length在 1 到 50,000 范围内。
    nums[i]是一个在 0 到 49,999 范围内的整数。
    
    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/degree-of-an-array
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */
}
