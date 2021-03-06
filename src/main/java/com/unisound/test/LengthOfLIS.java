package com.unisound.test;

import java.util.Arrays;

/*
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。

    示例:
    
    输入: [10,9,2,5,3,7,101,18]
    输出: 4 
    解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 
 */

//最长上升子序列
public class LengthOfLIS
{

    public static int lengthOfLIS(int[] nums)
    {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            res = Math.max(res, dp[i]);
        }
        return res;

    }

}
