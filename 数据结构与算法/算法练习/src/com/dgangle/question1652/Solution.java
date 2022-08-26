package com.dgangle.question1652;

/**
 * 1652.拆炸弹
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/2/16 15:27
 */
public class Solution {
    /*
        你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为n的循环数组code以及一个密钥k。
        为了获得正确的密码，你需要替换掉每一个数字。所有数字会同时被替换。

        如果k > 0，将第i个数字用 接下来k个数字之和替换。
        如果k < 0，将第i个数字用 之前k个数字之和替换。
        如果k == 0，将第i个数字用0替换。
        由于code是循环的，code[n-1]下一个元素是code[0]，且code[0]前一个元素是code[n-1]。

        给你循环数组code和整数密钥k，请你返回解密后的结果来拆除炸弹！

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/defuse-the-bomb
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static int[] decrypt(int[] code, int k) {
        int[] resArr = new int[code.length];

        for (int i = 0; i < code.length; i++) {
            if (k == 0) {
                resArr[i] = 0;
            } else if (k < 0) {
                
            } else {

            }
        }

        return resArr;
    }
}
