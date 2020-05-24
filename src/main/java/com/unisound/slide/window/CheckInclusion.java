package com.unisound.slide.window;

// 567. 字符串的排列
/*
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

    换句话说，第一个字符串的排列之一是第二个字符串的子串。
    
    示例1:
    
    输入: s1 = "ab" s2 = "eidbaooo"
    输出: True
    解释: s2 包含 s1 的排列之一 ("ba").
     
    
    示例2:
    
    输入: s1= "ab" s2 = "eidboaoo"
    输出: False

 */
public class CheckInclusion
{
    public boolean checkInclusion(String s1, String s2)
    {
        if (s2 == null || s2.length() == 0)
            return false;

        int[] needs = new int[26];
        int[] windows = new int[26];

        int left = 0, right = 0;
        int total = s1.length();

        // 记录需要覆盖的字母数
        for (char c : s1.toCharArray()) {
            needs[c - 'a']++;
        }

        while (right < s2.length()) {
            char chr = s2.charAt(right);
            // 包含需要覆盖的字符
            if (needs[chr - 'a'] > 0) {
                windows[chr - 'a']++; // 窗口添加

                // window字符小于等于需要覆盖的
                if (windows[chr - 'a'] <= needs[chr - 'a']) {
                    total--;

                }

            }

            while (total == 0) {
                if (right - left + 1 == s1.length()) {
                    return true;
                }

                char chl = s2.charAt(left);

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

        return false;

    }

}
