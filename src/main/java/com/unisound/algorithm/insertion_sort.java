package com.unisound.algorithm;

import java.util.Arrays;

public class insertion_sort
{
    public static void sort(int[] nums)
    {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int index = i;
            int array_i = nums[i];
            while (index > 0 && nums[index - 1] > array_i) {
                nums[index] = nums[index - 1];
                index -= 1;
            }
            nums[index] = array_i;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] {2, 4, 1, 4, 2};
        sort(nums);
        System.out.print(Arrays.toString(nums));

    }

}
