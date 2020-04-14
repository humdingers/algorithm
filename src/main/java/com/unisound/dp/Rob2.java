package com.unisound.dp;

import java.util.Arrays;

/*
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:

输入: [2,3,2]
输出: 3
解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。

 */
/*
 * 环状排列意味着第一个房子和最后一个房子中只能选择一个偷窃，因此可以把此环状排列房间问题约化为两个单排排列房间子问题：

在不偷窃第一个房子的情况下（即 nums[1:]），最大金额是 p_1；
在不偷窃最后一个房子的情况下（即 nums[:n−1]），最大金额是 p_2。
综合偷窃最大金额： 为以上两种情况的较大值，即 max(p1,p2) 。

 */
public class Rob2
{
    public int rob(int[] nums)
    {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        return Math.max(robber(Arrays.copyOfRange(nums, 0, len - 1)), robber(Arrays.copyOfRange(nums, 1, len)));
    }

    public int robber(int[] nums)
    {
        int pre = 0;
        int cur = 0;

        for (int num : nums) {

            int tmp = cur;
            cur = Math.max(cur, pre + num);
            pre = tmp;

        }

        return cur;

    }

}
