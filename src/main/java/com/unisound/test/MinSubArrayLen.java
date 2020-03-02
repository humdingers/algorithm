package com.unisound.test;

//长度最小的子数组
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
        int left = 0;
        int right = 0;
        int res = Integer.MAX_VALUE;

        int sum = 0;

        while (right < nums.length) {

            if (sum < s) {
                sum += nums[right];
            }

            right++;
            while (sum >= s) {

                res = Math.min(res, right - left);

                sum -= nums[left];
                left--;

            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;

    }

}
