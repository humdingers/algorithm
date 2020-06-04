package com.unisound.test;

import java.util.HashSet;

//无重复字符的最长子串

/*
  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 
 示例 1:
 
 输入: "abcabcbb"
 输出: 3 
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

*/
public class LengthOfLongestSubstring
{
    public int lengthOfLongestSubstring(String s)
    {
        HashSet<Character> window = new HashSet<Character>();

        int left = 0;
        int right = 0;

        int ans = 0;

        while (left < s.length() && right < s.length()) {
            if (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            } else {
                window.add(s.charAt(right));
                ans = Math.max(ans, right - left);
                right++;
            }
        }

        return ans;
    }

}
