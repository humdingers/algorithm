package com.unisound.slide.window;

import java.util.HashSet;
import java.util.Set;

public class LongSubstring
{
    // 无重复字符的最长子串
    public static int lengthOfLongestSubstring(String s)
    {
        int n = s.length();
        Set<Character> set = new HashSet<Character>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
                System.out.println(ans);
            } else {
                set.remove(s.charAt(i++));
            }
            System.out.println(set);
        }
        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(lengthOfLongestSubstring("abcba"));

    }

}
