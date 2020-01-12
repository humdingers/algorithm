package com.unisound.dp;

//最长重复子数组
/*
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

    示例 1:
    
    输入:
    A: [1,2,3,2,1]
    B: [3,2,1,4,7]
    输出: 3
    解释: 
    长度最长的公共子数组是 [3, 2, 1]。

 */
public class FindLength
{
    public int findLength(int[] A, int[] B)
    {
        int result = 0;
        int n = A.length + 1;
        int m = B.length + 1;
        int[][] dp = new int[n][m];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = A[i - 1] == B[j - 1] ? dp[i - 1][j - 1] + 1 : 0;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }

    public int findLengths(int[] A, int[] B)

    {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                    if (ans < memo[i][j])
                        ans = memo[i][j];
                }
            }
        }
        return ans;
    }

}
