package com.unisound.algorithm;

import java.util.Arrays;

//删除排序数组的重复项
/*
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:

给定数组 nums = [1,1,2], 

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
 */
public class RemoveElement
{
    public static int removeElement(int[] nums, int val)
    {
        int left = 0;
        for (int num : nums) {
            if (num != val) {
                nums[left++] = num;
            }
        }

        return left;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] {0, 1, 2, 4, 5};
        System.out.print(removeElement(nums, 5));
        System.out.print(Arrays.toString(nums));

    }

}
