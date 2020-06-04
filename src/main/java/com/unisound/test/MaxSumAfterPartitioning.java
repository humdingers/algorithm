package com.unisound.test;

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

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int j = i - 1;

            int max = A[j];

            while (i - j <= K && j >= 0) {
                max = Math.max(max, A[j]);
                dp[i] = Math.max(dp[i], dp[j] + max * (i - j));
                j--;

            }

        }

        return dp[n];
    }

}
