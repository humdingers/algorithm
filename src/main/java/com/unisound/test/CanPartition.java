package com.unisound.test;

//分割等和子集
/*
* 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].

*/
public class CanPartition
{
    public boolean canPartition(int[] nums)
    {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length][target + 1];

        if (nums[0] < target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {

                if (nums[i] == j) {
                    dp[i][j] = true;
                }

                else if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];

                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }

            if (dp[i][target]) {
                return true;
            }
        }

        return dp[nums.length - 1][target];

    }

}
