package com.unisound.binarySearch;

/*
 * 面试题 08.03. 魔术索引
魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。

示例1:

 输入：nums = [0, 2, 3, 4, 5]
 输出：0
 说明: 0下标的元素为0
示例2:

 输入：nums = [1, 1, 1]
 输出：1
 */
public class FindMagicIndex
{
    int res = -1;

    public int findMagicIndex(int[] nums)
    {
        search(nums, 0, nums.length - 1);
        return res;
    }

    public void search(int[] nums, int left, int right)
    {
        if (left > right) {
            return;
        }

        int mid = left + (right - left) / 2;
        // 如果找到，则从左半边继续查找更小的解
        if (nums[mid] == mid) {
            res = mid;
            search(nums, left, mid - 1);
        }

        else {
            // 如果未找到，则先搜索左半边，左半边无解的情况下再搜索右半边
            search(nums, left, mid - 1);
            // 这边要注意res在之前的查找中可能已经有值
            if (res == -1 || res > right) {
                search(nums, mid + 1, right);
            }
        }

    }

}
