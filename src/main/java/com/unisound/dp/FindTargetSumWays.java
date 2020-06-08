package com.unisound.dp;

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

        backpack(nums, S, 0, 0);
        return count;
    }

    public void backpack(int[] nums, int S, int start, int sum)
    {
        if (start > nums.length) {
            return;
        }

        if (start == nums.length) {
            if (sum == S) {
                count++;
            }
        }

        else {
            backpack(nums, S, start + 1, sum + nums[start]);
            backpack(nums, S, start + 1, sum - nums[start]);
        }
    }

    // 时间复杂度：O(N*sum)
    public int findTargetSumWaysDp(int[] nums, int S)
    {
        if (nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // corner case: when S is out of range [-sum, sum]
        if (S < -sum || S > sum) {
            return 0;
        }

        // f(i, j) = f(i-1, j-nums[i]) + f(i-1, j+nums[i]);

        // 定义：f(i, j) 表示对 0..i 的元素添加正负号后，数组和恰好为 j 的方案数。

        int[][] dp = new int[nums.length + 1][sum * 2 + 1];
        dp[0][sum] = 1;
        int leftBound = 0;
        int rightBound = sum * 2;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = leftBound; j < rightBound + 1; j++) {
                // try all possible sum of (previous sum j + current number nums[i - 1]) and all possible difference of
                // (previous sum j - current number nums[i - 1])
                if (j + nums[i - 1] <= rightBound) {
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
                if (j - nums[i - 1] >= leftBound) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum + S];
    }

    public int findTargetSumWaysDp1(int[] nums, int S)
    {

        int[][] dp = new int[nums.length][2001];
        // 用 dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数。考虑第 i 个数 nums[i]，它可以被添加 + 或 -
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][nums[i] + sum + 1000] += dp[i - 1][sum + 1000];
                    dp[i][-nums[i] + sum + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }

        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];

    }

}
