package com.unisound.slide.window;

import java.util.HashMap;
import java.util.Map;

public class LongString1
{

    // 无重复字符的最长子串
    public static int lengthOfLongestSubstring(String s)
    {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i); // 记录以往的字符滑动的距离
            }
            ans = Math.max(ans, j - i + 1);

            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(lengthOfLongestSubstring("bcbad"));

    }

}
