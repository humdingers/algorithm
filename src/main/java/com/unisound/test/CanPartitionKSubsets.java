package com.unisound.test;

//划分为k个相等的子集
/*
* 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。

 示例 1：
 
 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 输出： True
 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
  
 
 注意:
 
 1 <= k <= len(nums) <= 16
 0 < nums[i] < 10000

*/
public class CanPartitionKSubsets
{
    public boolean canPartitionKSubsets(int[] nums, int k)
    {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        int max = 0;

        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        int target = sum / k;

        if (sum % k != 0 || max > target) {
            return false;
        }

        boolean[] used = new boolean[nums.length];

        return backpack(nums, k, 0, 0, target, used);

    }

    public boolean backpack(int[] nums, int k, int start, int cur, int target, boolean[] used)
    {
        if (k == 0) {
            return true;
        }

        if (cur == target) {
            return backpack(nums, k - 1, 0, 0, target, used);
        }

        for (int i = start; i < nums.length; i++) {
            if (!used[i] && cur + nums[i] <= target) {
                used[i] = true;
                if (backpack(nums, k, i + 1, cur + nums[i], target, used)) {
                    return true;
                }
                used[i] = false;
            }

        }

        return false;

    }

}
