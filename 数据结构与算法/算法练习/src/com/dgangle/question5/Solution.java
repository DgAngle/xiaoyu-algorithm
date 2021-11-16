package com.dgangle.question5;

/**
 * 5. 最长回文子串
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/6/11 11:05
 */
public class Solution {
    /*
        给你一个字符串 s，找到 s 中最长的回文子串

        示例 1：
            输入：s = "babad"
            输出："bab"
            解释："aba" 同样是符合题意的答案。
        示例 2：
            输入：s = "cbbd"
            输出："bb"
        示例 3：
            输入：s = "a"
            输出："a"
        示例 4：
            输入：s = "ac"
            输出："a"

        提示：
            - 1 <= s.length <= 1000
            - s 仅由数字和英文字母（大写和/或小写）组成
    */

    public static String longestPalindrome(String s) {
        String childPalindrome = "";
        int length = s.length();
        char[] ch = new char[length];
        int max = 0; // 最大长度
        int k = 0; // 标记比较个数
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            ch[i] = c;
            // 两种情况, 中位数是1个
            while (i - k > 0 && ch[i] == ch[i - k - 1]) {
                max = i - k + 1;
                k++;
            }
            // 两种情况, 中位数是2个
            if (i - k > 1 && ch[i] == ch[i - k - 2]) {
                k++;
                max = i - k + 2;
            }
        }
        for (int i = k; i < length; i++) {
            childPalindrome += ch[i];
        }
        return childPalindrome;
    }

    public static void main(String[] args) {
        String s = "aaba";
        System.out.println(longestPalindrome(s));
    }
}
