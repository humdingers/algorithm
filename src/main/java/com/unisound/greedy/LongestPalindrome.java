package com.unisound.greedy;

// 最长回文串

/*
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

        在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
        
        注意:
        假设字符串的长度不会超过 1010。
        
        示例 1:
        
        输入:
        "abccccdd"
        
        输出:
        7
 */

public class LongestPalindrome
{

    public int longestPalindrome(String s)
    {
        int[] count = new int[128];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int res = 0;

        for (int num : count) {
            res += num / 2 * 2;

            if (num % 2 == 1 && res % 2 == 0) {
                res++;
            }

        }

        return res;

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
