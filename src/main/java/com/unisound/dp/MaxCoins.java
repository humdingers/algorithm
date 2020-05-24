package com.unisound.dp;

/*
 * 312. 戳气球
    有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
    
    现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
    
    求所能获得硬币的最大数量。
    
    说明:
    
    你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
    0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
    示例:
    
    输入: [3,1,5,8]
    输出: 167 
    解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
         coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */

// 时间复杂度：O(N^3)，需要根据所有可能的区间来找到最大分值，区间数为 N^2，迭代每个区间复杂度为 N，最终复杂度为 O(N^2) * O(N) = O(N^3)

/*
     * 为了处理数组边缘，将问题做一下转变，我们在数组左右各加一个 1，来找到只扎破中间气球所能得到的最大金币数。
    
    定义方法 dp，使其返回开区间 (left, right) 中所能得到的最大金币数。
    对于基础情况 (即 left + 1 == right)，这时候区间内没有整数，也没有气球需要加进去，因此 dp[left][right] = 0。随后在区间中加入气球，把问题分割成左右两部分来处理，找到最大金币数。
    
    在添加第 i 个气球后能得到的最大金币数为：
    
    nums[left] * nums[i] * nums[right] + dp(left, i) + dp(i, right)
    其中 nums[left] * nums[i] * nums[right] 为加入第 i 个气球所能得到的金币数
    ，dp(left, i) + dp(i, right) 为左右两部分分别能得到的最大金币数

 */

/*
 * 如上所述，空白加气球也就是逆向戳气球，假设最后一次戳气球是x，这时因为只剩x没有邻居可以直接算出值为x，前面和后面的空缺再递归调用戳气球就可以了
 */
public class MaxCoins
{
    public int maxCoins(int[] nums)
    {
        int n = nums.length + 2;

        int[] new_nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            new_nums[i + 1] = nums[i];
        }

        new_nums[0] = new_nums[n - 1] = 1;

        int[][] memo = new int[n][n];

        return dp(memo, new_nums, 0, n - 1);

    }

    public int dp(int[][] memo, int[] nums, int start, int end)
    {
        if (start + 1 == end) {
            return 0;
        }

        if (memo[start][end] > 0) {
            return memo[start][end];
        }

        int ans = 0;

        for (int i = start + 1; i < end; i++) {
            ans = Math.max(ans, nums[start] * nums[i] * nums[end] + dp(memo, nums, start, i) + dp(memo, nums, i, end));

        }

        memo[start][end] = ans;

        return ans;

    }

}
