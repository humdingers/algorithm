package com.unisound.dp;

//交错字符串

/*
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。

    示例 1:
    
    输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
    输出: true
    示例 2:
    
    输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
    输出: false
 */
public class IsInterleave
{

    // O(2^m+n)
    public boolean isInterleave(String s1, String s2, String s3)
    {

        return is_Interleave(s1, 0, s2, 0, s3, "");
    }

    public boolean is_Interleave(String s1, int i, String s2, int j, String s3, String res)
    {
        if (res.equals(s3) && i == s1.length() && j == s2.length()) {
            return true;
        }

        boolean ans = false;
        if (i < s1.length()) {
            ans |= is_Interleave(s1, i + 1, s2, j, s3, res + s1.charAt(i));
        }

        if (j < s2.length()) {
            ans |= is_Interleave(s1, i, s2, j + 1, s3, res + s2.charAt(j));
        }

        return ans;
    }

    // O(m⋅n)
    public boolean isInterleaveDp(String s1, String s2, String s3)
    {

        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        // 判断一个 s3 的前缀（用下标 k 表示），能否用 s1 和 s2 的前缀（下标分别为 i 和 j），仅仅依赖于 s1 前 i 个字符和 s2 前 j 个字符，而与后面的字符无关。

        // 为了实现这个算法， 我们将使用一个 2D 的布尔数组 dp 。dp[i][j] 表示用 s1 的前 (i+1) 和 s2 的前 (j+1)个字符，总共
        // (i+j+2) 个字符，是否交错构成 s3 的前缀。
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }

            }
        }
        return dp[s1.length()][s2.length()];

    }

}
