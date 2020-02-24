package com.unisound.dp;

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

/*
 * 1) 如果S的最后一位等于T的最后一位，则最大子序列就是{s1,s2,s3...si-1}和{t1,t2,t3...tj-1}的最大子序列+1

    (2) 如果S的最后一位不等于T的最后一位，那么最大子序列就是
    
    ① {s1,s2,s3..si}和 {t1,t2,t3...tj-1} 最大子序列
    
    ② {s1,s2,s3...si-1}和{t1,t2,t3....tj} 最大子序列
    
    以上两个自序列的最大值
    
    3.　边界
    
    只剩下{s1}和{t1}，如果相等就返回1，不等就返回


 */
public class LongestCommonSubsequence
{

    // dp[i][j] 的含义是：对于 s1[1..i] 和 s2[1..j]，它们的 LCS 长度是 dp[i][j]。

    // d[2][4] 的含义就是：对于 "ac" 和 "babc"，它们的 LCS 长度是 2。我们最终想得到的答案应该是 dp[3][6]。

    public static int longestCommonSubsequence(String text1, String text2)
    {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();

        // 我们专门让索引为 0 的行和列表示空串，dp[0][..] 和 dp[..][0] 都应该初始化为 0，这就是 base case。

        // 比如说，按照刚才 dp 数组的定义，dp[0][3]=0 的含义是：对于字符串 "" 和 "bab"，
        // 其 LCS 的长度为 0。因为有一个字符串是空串，它们的最长公共子序列的长度显然应该是 0

        int[][] dp = new int[s1.length + 1][s2.length + 1];

        // 当 S1==Sj 时，那么就能在 S1 的前 i-1 个字符与 S2 的前 j-1 个字符最长公共子序列的基础上再加上 S1 这个值，
        // 最长公共子序列长度加 1，即 dp[i][j] = dp[i-1][j-1] + 1。
        // 当 S1i != S2j 时，此时最长公共子序列为 S1 的前 i-1 个字符和 S2 的前 j 个字符最长公共子序列，
        // 或者 S1 的前 i 个字符和 S2 的前 j-1 个字符最长公共子序列，取它们的最大者，即
        // dp[i][j] = max{ dp[i-1][j], dp[i][j-1] }。

        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return dp[s1.length][s2.length];

    }

    public static void main(String[] args)
    {
        System.out.print(longestCommonSubsequence("aabc", "cbaa"));

    }

}
