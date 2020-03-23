package com.unisound.test;

//最长公共子序列
/*
    给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
  
  一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
  例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
  
  若这两个字符串没有公共子序列，则返回 0。
  
   
  
  示例 1:
  
  输入：text1 = "abcde", text2 = "ace" 
  输出：3  
  解释：最长公共子序列是 "ace"，它的长度为 3。
  示例 2:
  
  输入：text1 = "abc", text2 = "abc"
  输出：3
  解释：最长公共子序列是 "abc"，它的长度为 3。

*/

public class LongestCommonSubsequence
{

    // dp[i][j] 的含义是：对于 s1[1..i] 和 s2[1..j]，它们的 LCS 长度是 dp[i][j]。

    // d[2][4] 的含义就是：对于 "ac" 和 "babc"，它们的 LCS 长度是 2。我们最终想得到的答案应该是 dp[3][6]。

    public static int longestCommonSubsequence(String text1, String text2)
    {
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();

        int[][] dp = new int[charArray1.length + 1][charArray2.length + 1];

        for (int i = 1; i <= charArray1.length; i++) {
            for (int j = 1; j <= charArray2.length; j++) {
                if (charArray1[i - 1] == charArray2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

            }
        }

        return dp[charArray1.length][charArray2.length];

    }

}
