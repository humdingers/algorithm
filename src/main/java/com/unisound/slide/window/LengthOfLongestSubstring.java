package com.unisound.slide.window;

import java.util.HashSet;
import java.util.Set;

// 无重复字符的最长子串

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
        Set<Character> set = new HashSet<Character>();
        int i = 0, j = 0, ans = 0;
        int n = s.length();

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }

        }
        return ans;

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
