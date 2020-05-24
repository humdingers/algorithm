package com.unisound.dp;

public class MaxSumAfterPartitioning
{
    public int maxSumAfterPartitioning(int[] A, int K)
    {
        int n = A.length;
        // dp[i]表示A[0]...A[i]的最大和
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int j = i - 1; // j从i-1开始往0方向滚动
            int max = dp[i]; // 此时最大和暂定当前dp[i]最大

            // 不能超过k
            while (i - j <= K && j >= 0) {
                max = Math.max(max, A[j]);
                // 此时dp[j]的最大和+max*找寻的区间j-i
                dp[i] = Math.max(dp[i], dp[j] + max * (i - j));
                j--;
            }
        }

        return dp[n];
    }

}
