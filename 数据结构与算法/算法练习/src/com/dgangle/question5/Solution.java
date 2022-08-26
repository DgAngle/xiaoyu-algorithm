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
        String s = "abcd";
        System.out.println(longestPalindrome(s));
    }

    // 方式一：使用动态规划
    public static String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) return s;

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化, 所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray(); // 将字符串转成数组
        // 枚举子串长度, 从2个开始
        for (int L = 2; L <= len; L++) {
            // 枚举左边界, 左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                int j = L + i - 1; // 右边界
                if (j >= len) break; // 如果右边界越界, 退出循环

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
