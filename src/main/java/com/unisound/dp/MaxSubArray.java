package com.unisound.dp;

// 最大子序和
/*
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    
    示例:
    
    输入: [-2,1,-3,4,-1,2,1,-5,4],
    输出: 6
    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

 */

public class MaxSubArray
{

    public int maxSubArray(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            // dp[i] 就是 “以 i 结尾的所有子数组的最大值”
            // 历史的和值加上当前值是否能超过当前值，如果超过说明历史和值和当前值相加，此时就是目前的最大和值
            // 否则最大和值就变成当前值
            if (sum + num > num) {
                sum += num;
            } else {
                sum = num;
            }

            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
