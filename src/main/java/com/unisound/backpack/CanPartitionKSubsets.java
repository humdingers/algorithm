package com.unisound.backpack;

// 划分为k个相等的子集
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
// O(k*2^n)
public class CanPartitionKSubsets
{
    public boolean canPartitionKSubsets(int[] nums, int k)
    {
        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            maxNum = Math.max(nums[i], maxNum);
        }

        int target = sum / k;
        // 和能被k整除，最大数不能超过每一份的和
        if (sum % k > 0 || maxNum > target) {
            return false;
        }

        boolean[] used = new boolean[nums.length];
        return backpack(nums, k, target, 0, 0, used);

    }

    public boolean backpack(int[] nums, int k, int target, int cur, int start, boolean[] used)
    {
        if (k == 0) {
            return true;
        }

        if (cur == target) {
            // 构建下一个集合
            return backpack(nums, k - 1, target, 0, 0, used);
        }

        for (int i = start; i < nums.length; i++) {
            if (!used[i] && cur + nums[i] <= target) {
                used[i] = true;
                // 因为本题只要找到一个结果就行了，需要在找到这个结果的时候就立刻返回
                // 如果需要找到所有的结果（所有的划分），那么这个时候的backtracking( )不需要返回值，这个时候添加一个参数ans（一个容器），用来装全部的结果

                if (backpack(nums, k, target, cur + nums[i], i + 1, used)) {
                    return true;
                }
                used[i] = false;
            }
        }

        return false;

    }

}
