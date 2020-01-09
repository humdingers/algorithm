package com.unisound.slide.window;

import java.util.HashMap;

public class MinWindow
{

    // 最小覆盖子串
    /*
             给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
            
            示例：
            
            输入: S = "ADOBECODEBANC", T = "ABC"
            输出: "BANC"

     */
    public String minWindow(String s, String t)
    {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int left = 0, right = 0, count = 0;
        int minLeft = 0, minLen = s.length() + 1;

        for (Character chars : t.toCharArray()) {
            if (map.containsKey(chars)) {
                map.put(chars, map.get(chars) + 1);
            } else {
                map.put(chars, 1);
            }
        }

        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);

                if (map.get(s.charAt(right)) >= 0) {
                    count++;
                }

                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }

                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {
                            count--;
                        }
                    }

                    left++;

                }
            }

            right++;

        }

        if (minLen > s.length()) {
            return "";
        }

        return s.substring(minLeft, minLeft + minLen);

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
