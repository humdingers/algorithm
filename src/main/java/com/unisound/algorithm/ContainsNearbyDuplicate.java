package com.unisound.algorithm;

import java.util.HashSet;
import java.util.Set;

/*
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。

        示例 1:
        
        输入: nums = [1,2,3,1], k = 3
        输出: true
。
 */
public class ContainsNearbyDuplicate
{

    // 存在重复元素 II
    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        Set<Integer> windows = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (windows.contains(nums[i]))
                return true;

            windows.add(nums[i]);

            if (windows.size() > k) { // 此时window已经添加一个新元素，窗口大小为k+1,所以删除i-k-1+1
                windows.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
