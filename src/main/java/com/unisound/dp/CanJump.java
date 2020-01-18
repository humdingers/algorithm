package com.unisound.dp;

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
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true; // 默认能跳到终点
        // 反向遍历
        for (int i = nums.length - 2; i >= 0; i--) {
            // 当前位置可以向后跳跃的跳跃距离，不能超过数组最大长度
            int futherJump = Math.min(i + nums[i], nums.length - 1);
            // 查找这个跳跃距离区间是否存在可以过渡跳跃的点或者直接跳跃过去，存在说明可以跳跃到i+nums[i]位置，把dp[i]置为true
            for (int j = i + 1; j <= futherJump; j++) {
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
