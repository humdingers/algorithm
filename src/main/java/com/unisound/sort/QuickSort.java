package com.unisound.sort;

import java.util.Arrays;

public class QuickSort
{

    public static void quicksort(int[] nums, int startIndex, int endIndex)
    {
        if (startIndex >= endIndex) {
            return;
        }
        int privotIndex = partion(nums, startIndex, endIndex);

        quicksort(nums, startIndex, privotIndex - 1);
        quicksort(nums, privotIndex + 1, endIndex);

    }

    public static int partion(int nums[], int startIndex, int endIndex)
    {
        int privot = nums[startIndex];
        int mark = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (nums[i] < privot) {
                mark++;
                int tmp = nums[mark];

                nums[mark] = nums[i];
                nums[i] = tmp;

            }

        }
        nums[startIndex] = nums[mark];
        nums[mark] = privot;

        return mark;

    }

    public static void main(String[] args)
    {
        int[] arr = new int[] {4, 4, 6, 5, 3, 2, 8, 1};
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

}
