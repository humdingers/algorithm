package com.unisound.dp;

/*
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。

 

示例 1：

输入：nums = [3,6,5,1,8]
输出：18
解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
示例 2：

输入：nums = [4]
输出：0
解释：4 不能被 3 整除，所以无法选出数字，返回 0。

 */

public class MaxSumDivThree
{
    public int maxSumDivThree(int[] nums)
    {

        // 余数为0,1,2,对应的最大和
        int[] dp = new int[3];
        // 当余数mod为1.那么a = dp[3 - 1];
        // a = dp[2]; 由于余数1和余数2相加就是余数为0。
        // 因此 dp[0] = max(dp[0], a + nums[i])； 同理后面求余数为1，和余数为2也是。牛皮，挺难想的。换一种写法估计更好理解点。
        for (int i = 0; i < nums.length; i++) {
            int mod = nums[i] % 3;
            int a = dp[(3 + 0 - mod) % 3];
            int b = dp[(3 + 1 - mod) % 3];
            int c = dp[(3 + 2 - mod) % 3];
            if (a != 0 || mod == 0)
                dp[0] = Math.max(dp[0], a + nums[i]);
            if (b != 0 || mod == 1)
                dp[1] = Math.max(dp[1], b + nums[i]);
            if (c != 0 || mod == 2)
                dp[2] = Math.max(dp[2], c + nums[i]);
        }
        return dp[0];
    }
}
