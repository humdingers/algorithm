package com.unisound.slide.window;

// 长度最小的子数组
/*
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

    示例: 
    
    输入: s = 7, nums = [2,3,1,2,4,3]
    输出: 2
    解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组

 */
public class MinSubArrayLen
{
    public int minSubArrayLen(int s, int[] nums)
    {
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            int rightVal = nums[right];

            if (sum < s) {
                sum += rightVal;
            }

            right++;

            while (sum >= s) {
                res = Math.min(right - left, res);

                sum = sum - nums[left];

                left++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;

    }

}
