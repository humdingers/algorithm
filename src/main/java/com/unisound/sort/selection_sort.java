package com.unisound.sort;

import java.util.Arrays;

public class selection_sort
{

    public static void sort(int[] nums)
    {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int min_index = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[min_index]) {
                    min_index = j;
                }
            }
            int tmp = nums[min_index];
            nums[min_index] = nums[i];
            nums[i] = tmp;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] {2, 4, 1, 4, 2};
        sort(nums);
        System.out.print(Arrays.toString(nums));

    }

}
