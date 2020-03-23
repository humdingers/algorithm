package com.unisound.test;

import java.util.HashMap;
import java.util.Map;

public class MinWindow
{

    // 最小覆盖子串
    /*
     * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。 示例： 输入: S = "ADOBECODEBANC", T = "ABC" 输出: "BANC"
     */

    public String minWindow(String s, String t)
    {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }

        Map<Character, Integer> window = new HashMap<Character, Integer>();
        Map<Character, Integer> needs = new HashMap<Character, Integer>();

        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int minleft = 0;
        int minlen = s.length() + 1;

        int left = 0;
        int right = 0;

        int count = needs.size();

        while (right < s.length()) {
            char chr = s.charAt(right);
            if (needs.containsKey(chr)) {
                window.put(chr, window.getOrDefault(chr, 0) + 1);
                if (window.get(chr).compareTo(needs.get(chr)) == 0) {
                    count--;
                }
            }

            right++;

            while (count == 0) {
                if (right - left < minlen) {
                    minlen = right - left;
                    minleft = left;
                }
                char chl = s.charAt(left);
                if (needs.containsKey(chl)) {
                    window.put(chl, window.get(chl) - 1);
                    if (window.get(chl) < (needs.get(chl))) {
                        count++;
                    }
                }

                left++;
            }

        }

        if (minlen > s.length()) {
            return "";

        }

        return s.substring(minleft, minleft + minlen);

    }

}
