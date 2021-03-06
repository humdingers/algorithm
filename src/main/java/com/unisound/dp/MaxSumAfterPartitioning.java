package com.unisound.dp;

/*
 * 1043. 分隔数组以得到最大和
给出整数数组 A，将该数组分隔为长度最多为 K 的几个（连续）子数组。分隔完成后，每个子数组的中的值都会变为该子数组中的最大值。

返回给定数组完成分隔后的最大和。

 

示例：

输入：A = [1,15,7,9,2,5,10], K = 3
输出：84
解释：A 变为 [15,15,15,9,10,10,10]
 */
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
            // int max = A[j];
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
