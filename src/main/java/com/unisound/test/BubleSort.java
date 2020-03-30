package com.unisound.test;

import java.util.Arrays;

public class BubleSort
{
    public static void sort(int[] nums)
    {
        int sortBoarder = nums.length;
        int lastExchange = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isSort = true;
            for (int j = 1; j < sortBoarder; j++) {
                if (nums[j - 1] > nums[j]) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                    isSort = false;
                    lastExchange = j;
                }
            }
            sortBoarder = lastExchange;
            if (isSort) {
                break;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] {2, 5, 4, 1, 4, 2};
        // sort(nums);
        sort(nums);
        System.out.print(Arrays.toString(nums));

    }
}
