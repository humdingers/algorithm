package com.unisound.test;

//跳跃游戏
/*
* 给定一个非负整数数组，你最初位于数组的第一个位置。

  数组中的每个元素代表你在该位置可以跳跃的最大长度。
  
  判断你是否能够到达最后一个位置。
  
  示例 1:
  
  输入: [2,3,1,1,4]
  输出: true
  解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。

*/

public class CanJump
{
    public boolean canJump(int[] nums)
    {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int len = nums.length;

        boolean[] dp = new boolean[nums.length];

        dp[len - 1] = true;

        for (int i = len - 1; i >= 0; i--) {
            int jump = Math.min(i + nums[i], len - 1);
            for (int j = i; j <= jump; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
