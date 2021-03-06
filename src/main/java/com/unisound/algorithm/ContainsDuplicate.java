package com.unisound.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 给定一个整数数组，判断是否存在重复元素。

    如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
    
    示例 1:
    
    输入: [1,2,3,1]
    输出: true

 */
public class ContainsDuplicate
{

    // 存在重复元素
    public boolean containsDuplicate(int[] nums)
    {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int x : nums) {
            if (!set.add(x))
                return true;
        }
        return false;
    }

    public boolean containsDuplicates(int[] nums)
    {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
