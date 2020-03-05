package com.unisound.dp;

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

/*
 * 作为“0-1 背包问题”，它的特点是：“每个数只能用一次”。思路是：物品一个一个选，容量也逐个放大考虑。我们实际生活中也是这样做的，尝试一个一个把候选物品放入“背包”。

具体做法是：画一个 len 行，target + 1 列的表格。这里 len 是物品的个数，target 是背包的容量。len 行表示一个一个物品考虑，target + 1多出来的那 1 列，表示背包容量从 0 开始，很多时候，我们需要考虑这个容量为 0 的数值。

状态定义：dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j。
状态转移方程：很多时候，状态转移方程思考的角度是“分类讨论”，对于“0-1 背包问题”而言就是“当前考虑到的数字选与不选”。
1、不选择 nums[i]，如果在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，那么 dp[i][j] = true；

2、选择 nums[i]，如果在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i]。

状态转移方程是：

dp[i][j] = dp[i - 1][j] or dp[i - 1][j - nums[i]]
一般写出状态转移方程以后，就需要考虑边界条件（一般而言也是初始化条件）。

1、j - nums[i] 作为数组的下标，一定得保证大于等于 0 ，因此 nums[i] <= j；
2、注意到一种非常特殊的情况：j 恰好等于 nums[i]，即单独 nums[j] 这个数恰好等于此时“背包的容积” j，这也是符合题意的。

 */

//时间复杂度：O(NC)：这里 N是数组元素的个数，C是数组元素的和的一半
public class CanPartition
{
    public boolean canPartition(int[] nums)
    {
        int len = nums.length;
        if (len == 0) {
            return false;
        }

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;

        // dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j。
        boolean[][] dp = new boolean[nums.length][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // 1、不选择 nums[i]，如果在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，那么 dp[i][j] = true；

        // 2、选择 nums[i]，如果在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i]。

        // 状态转移方程是： dp[i][j] = dp[i - 1][j] or dp[i - 1][j - nums[i]]

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                // nums[i]>j时 直接等于上个数结果
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                } else if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }

            }

            // or 的结果只要为真，表格下面所有的值都为真，因此在填表的时候，只要表格的最后一列是 true
            // 由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作
            if (dp[i][target]) {
                return true;
            }
        }

        return dp[len - 1][target];
    }

}
