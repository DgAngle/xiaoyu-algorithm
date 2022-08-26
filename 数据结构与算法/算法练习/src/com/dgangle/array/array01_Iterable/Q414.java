package com.dgangle.array.array01_Iterable;

/**
 * 414. 第三大的数
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/8/16 16:11
 */
public class Q414 {
    public static void main(String[] args) {
        // int[] nums = {3, 2, 1};
        int[] nums = {1, 2, -2147483648};
        System.out.println(thirdMax(nums));
    }

    public static int thirdMax(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        Integer a = null, b = null, c = null; // c最大, a第三大
        for (int num : nums) {
            if (c == null || num > c) {
                a = b;
                b = c;
                c = num;
            } else if (c > num && (b == null || num > b)) {
                a = b;
                b = num;
            } else if (b != null && b > num && (a == null || num > a)) {
                a = num;
            }
        }

        return a == null ? c : a;
    }

    /*
    给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。

    示例 1：
    输入：[3, 2, 1]
    输出：1
    解释：第三大的数是 1 。
    示例 2：

    输入：[1, 2]
    输出：2
    解释：第三大的数不存在, 所以返回最大的数 2 。
    示例 3：

    输入：[2, 2, 3, 1]
    输出：1
    解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
    此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
    

    提示：
    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1
    
    进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/third-maximum-number
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */
}
