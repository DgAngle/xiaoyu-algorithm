package com.dgangle.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode, 3: 无重复字符的最长子串
 *
 * @Author gqshuang
 * @Date 2021/5/27 14:18
 * @Version 1.0
 */
public class Solution {
   /*
   给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    示例 1:
        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:
        输入: s = "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:
        输入: s = "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
        请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    示例 4:
        输入: s = ""
        输出: 0

    提示：
        0 <= s.length <= 5 * 104
        s 由英文字母、数字、符号和空格组成
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */

    /**
     * 通过 (参考题解)
     */
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) { // 是否重复
                start = Math.max(map.get(ch) + 1, start); // 如果重复了, 重新计算不重复字符的起始位置
            }
            maxLength = Math.max(maxLength, i - start + 1); // 已知的最大值 与 当前字符的位置进行比较
            map.put(ch, i);
        }
        return maxLength;
    }

    /**
     * 通过
     */
    public static int lengthOfLongestSubstring_old(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int length = 0;
        String tempStr = "";
        char head = s.charAt(0);
        tempStr = head + "";
        for (int i = 1; i < s.length(); i++) {
            char next = s.charAt(i);
            int index = tempStr.indexOf(next);
            if (index != -1) { // 表明目前的字符串有重复的
                int tempIndex = tempStr.length();
                i = i - (tempIndex - index) + 1;
                if (tempIndex > length) {
                    length = tempStr.length();
                }
                head = s.charAt(i);
                tempStr = head + "";
            } else {
                tempStr += next;
            }
        }
        if (tempStr.length() > length) {
            length = tempStr.length();
        }
        return length;
    }


    public static void main(String[] args) {
        String s = "abcdafghemnca";
        int length = lengthOfLongestSubstring(s);
        System.out.println("结果: " + length);
    }
}
