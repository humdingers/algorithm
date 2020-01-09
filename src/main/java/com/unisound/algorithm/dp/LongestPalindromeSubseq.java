package com.unisound.algorithm.dp;

// 最长回文子序列
/*
     给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
    
    示例 1:
    输入:
    
    "bbbab"
    输出:
    
    4
    一个可能的最长回文子序列为 "bbbb"。

 */
public class LongestPalindromeSubseq
{
    public int longestPalindromeSubseq(String s)
    {
        int n = s.length();

        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1; // base case 如果只有一个字符，显然最长回文子序列长度是 1 ,i、j重叠
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }

            }
        }

        return dp[0][n - 1];

    }

}
