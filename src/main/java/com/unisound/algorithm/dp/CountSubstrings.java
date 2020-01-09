package com.unisound.algorithm.dp;

//回文子串

/*
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

    具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
    
    示例 1:
    
    输入: "abc"
    输出: 3
    解释: 三个回文子串: "a", "b", "c".
 */
public class CountSubstrings
{
    public int countSubstrings(String s)
    {
        int res = 0;
        boolean dp[][] = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;

    }

}
