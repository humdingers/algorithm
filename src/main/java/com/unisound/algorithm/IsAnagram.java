package com.unisound.algorithm;

public class IsAnagram
{

    // 有效的字母异位词
    /*
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
     * 示例 1: 输入: s = "anagram", 
     * t = "nagaram"
     *  输出: true
     */
    public static boolean isAnagram(String s, String t)
    {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        System.out.print(isAnagram("aab", "ab"));

    }

}
