package com.unisound.sort;

import java.util.Arrays;

public class bubble_sort
{

    public static void sort(int[] nums)
    {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 1; j < len - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;

                }
            }
        }
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] {2, 5, 4, 1, 4, 2};
        sort(nums);
        System.out.print(Arrays.toString(nums));

    }

}
