package com.unisound.binarySearch;

//搜索旋转排序数组
/*
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    
    ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    
    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    
    你可以假设数组中不存在重复的元素。
    
    你的算法时间复杂度必须是 O(log n) 级别。
    
    示例 1:
    
    输入: nums = [4,5,6,7,0,1,2], target = 0
    输出: 4

 */
//O(logN)
public class RotateSearch
{
    public int search(int[] nums, int target)
    {
        if (nums == null || nums.length == 0) {
            return -1;

        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 左半部分有序,注意此处用小于等于 //注意二分查找只能在有序的情况，所以先判断左边有序还是右边有序
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) { // target在左边范围内
                    right = mid - 1;
                } else {// target不在左边范围内
                    left = mid + 1;
                }

            } else {// 右半部分有序
                if (target > nums[mid] && target <= nums[right]) { // target在右边范围内
                    left = mid + 1;
                } else {// target在左边范围内，从左边找
                    right = mid - 1;
                }
            }
        }

        return -1;

    }

}
