package com.unisound.algorithm.sort;

import java.util.Arrays;

public class select_sort
{
    public static void sort(int[] nums)
    {
        for (int i = 0; i < nums.length; i++) {
            int min_index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min_index]) {
                    min_index = j;
                }

            }
            int temp = nums[min_index];
            nums[min_index] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] {2, 4, 1, 4, 2};
        sort(nums);
        System.out.print(Arrays.toString(nums));

    }

}
