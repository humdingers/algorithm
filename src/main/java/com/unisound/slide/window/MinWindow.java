package com.unisound.slide.window;

import java.util.HashMap;

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

        HashMap<Character, Integer> window = new HashMap<Character, Integer>();

        // 滑动窗口左右指针
        int left = 0, right = 0;

        // 记录要覆盖的字符串数，以此判断窗口是否符合要求
        int count = t.length();

        // 记录子串在字符串S的最小起始位置和偏移长度
        int minLeft = 0, minLen = s.length() + 1;

        // 统计要覆盖的t中各个字母的个数
        // 反其道行之，当记录的window的各个字符（即所需覆盖的字符都为0时满足需求
        for (Character chars : t.toCharArray()) {
            if (window.containsKey(chars)) {
                window.put(chars, window.get(chars) + 1);
            } else {
                window.put(chars, 1);
            }
        }

        while (right < s.length()) {
            // 滑动的过程中去递减窗口window内的字符，当字符都变为0时即满足需求，然后增加left，优化minleft
            if (window.containsKey(s.charAt(right))) {
                // 找到就递减相应字符
                window.put(s.charAt(right), window.get(s.charAt(right)) - 1);

                // 保证窗口内字符数不能为负，如果不为负，说明此次添加的字符符合要求，相应的count减小
                if (window.get(s.charAt(right)) >= 0) {
                    count--;
                }

                // 触发满足条件
                while (count == 0) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1; // 寻找最小覆盖的长度
                    }

                    // 找到可行解之后，开始移动left缩小窗口，优化
                    if (window.containsKey(s.charAt(left))) {
                        window.put(s.charAt(left), window.get(s.charAt(left)) + 1);

                        // 当增加这个字符，使得窗口map里的字符不再为0，>0时，计数count增加，count增加跳出循环，
                        // 说明不能再缩小,继续缩小不符合要求
                        if (window.get(s.charAt(left)) > 0) {
                            count++;
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

    public String minWindowCopy(String s, String t)
    {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> window = new HashMap<Character, Integer>();

        HashMap<Character, Integer> needs = new HashMap<Character, Integer>();

        for (char c : t.toCharArray()) {
            if (needs.containsKey(c)) {
                needs.put(c, needs.get(c) + 1);

            } else {
                needs.put(c, 1);
            }
        }
        int left = 0;
        int right = 0;
        int match = 0;

        int minleft = 0;
        int minlen = s.length() + 1;

        while (right < s.length()) {
            char rc = s.charAt(right);
            if (needs.containsKey(rc)) {
                if (window.containsKey(rc)) {
                    window.put(rc, window.get(rc) + 1);

                } else {
                    window.put(rc, 1);
                }

                if (window.get(rc).compareTo(needs.get(rc)) == 0) {
                    match++;
                }
            }

            right++;

            while (match == needs.size()) {
                if (right - left < minlen) {
                    minlen = right - left;
                    minleft = left;
                }
                char lc = s.charAt(left);
                if (needs.containsKey(lc)) {
                    window.put(lc, window.get(lc) - 1);
                    if (window.get(lc) < needs.get(lc)) {
                        match--;
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

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
