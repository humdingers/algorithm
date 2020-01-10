package com.unisound.slide.window;

import java.util.ArrayList;
import java.util.List;

//找到字符串中所有字母异位词
/*
   给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

    字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
    
    说明：
    
    字母异位词指字母相同，但排列不同的字符串。
    不考虑答案输出的顺序。
    示例 1:
    
    输入:
    s: "cbaebabacd" p: "abc"
    
    输出:
    [0, 6]
    
    解释:
    起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
    起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。

 */
public class FindAnagrams
{
    // 跟最小覆盖有些不同，这里需要覆盖的字符、字符数都相同
    public List<Integer> findAnagrams(String s, String p)
    {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || s.length() == 0)
            return res;

        int[] needs = new int[26];
        int[] windows = new int[26];

        int left = 0, right = 0;
        int total = p.length();

        // 记录需要覆盖的字母数
        for (char c : p.toCharArray()) {
            needs[c - 'a']++;
        }

        while (right < s.length()) {
            char chr = s.charAt(right);
            // 包含需要覆盖的字符
            if (needs[chr - 'a'] > 0) {
                windows[chr - 'a']++; // 窗口添加

                // window字符小于等于需要覆盖的
                if (windows[chr - 'a'] <= needs[chr - 'a']) {
                    total--;

                }

            }

            while (total == 0) {
                if (right - left + 1 == p.length()) {
                    res.add(left);
                }

                char chl = s.charAt(left);

                // 包含需要覆盖的字符
                if (needs[chl - 'a'] > 0) {
                    windows[chl - 'a']--; // 窗口缩减
                    if (windows[chl - 'a'] < needs[chl - 'a']) {
                        total += 1; // 跳出循环不满足需求
                    }

                }

                left++;

            }

            right++;

        }

        return res;

    }

}
