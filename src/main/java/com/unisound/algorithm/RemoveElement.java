package com.unisound.algorithm;

import java.util.Arrays;

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
