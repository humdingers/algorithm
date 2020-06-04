package com.unisound.binarySearch;

/*
     * 面试题03. 数组中重复的数字
    找出数组中重复的数字。
    
    
    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
    
    示例 1：
    
    输入：
    [2, 3, 1, 0, 2, 5, 3]
    输出：2 或 3 
 */

/*
 * 如果没有重复数字，那么正常排序后，数字i应该在下标为i的位置，
 * 所以思路是重头扫描数组，遇到下标为i的数字如果不是i的话，
 * （假设为m),那么我们就拿与下标m的数字交换。在交换过程中，如果有重复的数字发生，那么终止返回ture

 */
public class FindRepeatNumber
{
    public int findRepeatNumber(int[] nums)
    {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                swap(nums, nums[i], i);
            }
        }

        return -1;

    }

    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
