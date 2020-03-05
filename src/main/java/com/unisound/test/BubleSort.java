package com.unisound.test;

public class BubleSort
{
    public static void sort(int[] nums)
    {

        int lastExchange = nums.length;
        int sortBoarder = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 1; j < sortBoarder; j++) {
                if (nums[j - 1] > nums[j]) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];

                    nums[j] = tmp;

                    isSorted = false;
                    lastExchange = j;
                }
            }

            sortBoarder = lastExchange;
            if (isSorted) {
                break;
            }
        }

    }
}
