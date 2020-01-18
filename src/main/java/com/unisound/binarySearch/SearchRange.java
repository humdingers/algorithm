package com.unisound.binarySearch;

//在排序数组中查找元素的第一个和最后一个位置
/*
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

    你的算法时间复杂度必须是 O(log n) 级别。
    
    如果数组中不存在目标值，返回 [-1, -1]。
    
    示例 1:
    
    输入: nums = [5,7,7,8,8,10], target = 8
    输出: [3,4]

 */
public class SearchRange
{
    // 左边界
    int left_bound(int[] nums, int target)
    {
        if (nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid; // 缩小「搜索区间」的上界 right，在区间 [left, mid) 中继续搜索，即不断向左收缩，达到锁定左侧边界的目的。
            } else if (nums[mid] < target) {
                left = mid + 1; // 「搜索区间」是 [left, right) 左闭右开，所以当 nums[mid] 被检测之后，下一步的搜索区间应该去掉 mid 分割成两个区间，即 [left, mid)
                                // 或 [mid + 1, right)。
            } else if (nums[mid] > target) {
                right = mid;
            }

        }

        if (left == nums.length)
            return -1;
        return nums[left] == target ? left : -1;

    }

    // 右边界
    int right_bound(int[] nums, int target)
    {
        if (nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length;
        // < 时 左闭右开[left,right)
        // while(left < right) 终止的条件是 left == right，此时搜索区间 [left, left) 恰巧为空，所以可以正确终止。
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 增大「搜索区间」的下界 left，使得区间不断向右收缩，达到锁定右侧边界的目的
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }

        }

        if (left == 0)
            return -1;
        return nums[left - 1] == target ? left - 1 : -1;

    }

    public int[] searchRange(int[] nums, int target)
    {

        int leftIdx = left_bound(nums, target);

        int rightIdx = right_bound(nums, target);

        return new int[] {leftIdx, rightIdx};
    }
}
