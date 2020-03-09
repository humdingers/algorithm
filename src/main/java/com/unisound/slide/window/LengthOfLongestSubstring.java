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

//时间复杂度：O(2n) = O(n)，在最糟糕的情况下，每个字符将被 i 和 j 访问两次
public class LengthOfLongestSubstring
{
    public int lengthOfLongestSubstring(String s)
    {
        Set<Character> set = new HashSet<Character>();
        // 使用set作为window，和最小覆盖子串一样，反行之，如果set不包含当前字符就添加到window,如果包含就移动左指针缩小
        int left = 0, right = 0, ans = 0;
        int n = s.length();

        while (left < n && right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                ans = Math.max(ans, right - left);
            } else {
                // 出现重复字符
                // 增加left指针，同时从左边开始删除字符，直至不包含重复字符
                set.remove(s.charAt(left++));
            }

        }
        return ans;

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
