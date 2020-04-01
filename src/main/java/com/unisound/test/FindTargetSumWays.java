package com.unisound.test;

//目标和
/*
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。

示例 1:

输入: nums: [1, 1, 1, 1, 1], S: 3
输出: 5
解释: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。
初始数组非空，且长度不会超过20。
初始的数组的和不会超过1000。
保证返回的最终结果能被32位整数存下。
*/

/*
* dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
  也可以写成递推的形式：
  
  dp[i][j + nums[i]] += dp[i - 1][j]
  dp[i][j - nums[i]] += dp[i - 1][j]
  由于数组中所有数的和不超过 1000，那么 j 的最小值可以达到 -1000。在很多语言中，是不允许数组的下标为负数的，因此我们需要给 dp[i][j] 的第二维预先增加 1000，即：
  
  dp[i][j + nums[i] + 1000] += dp[i - 1][j + 1000]
  dp[i][j - nums[i] + 1000] += dp[i - 1][j + 1000]

*/

public class FindTargetSumWays
{
    int count = 0;

    // 时间复杂度：O(2^N)，其中 N 是数组 nums 的长度
    public int findTargetSumWays(int[] nums, int S)
    {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        backpack(nums, S, 0, 0);

        return count;

    }

    public void backpack(int nums[], int S, int cur, int start)
    {
        if (start > nums.length) {
            return;
        }

        if (start == nums.length) {
            if (cur == S) {
                count++;
            }
        } else {

            backpack(nums, S, cur + nums[start], start + 1);
            backpack(nums, S, cur - nums[start], start + 1);

        }

    }

    public int findTargetSumWays1(int[] nums, int S)
    {
        int[][] dp = new int[nums.length][2001];

        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;

        for (int i = 0; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];

                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];

                }
            }
        }

        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
