package com.unisound.sort;

import java.util.Arrays;

public class merge_sort
{
    public static void merge(int[] array, int low, int mid, int high)
    {
        int[] tmp = new int[array.length];
        for (int k = low; k <= high; k++) {
            tmp[k] = array[k];
        }
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                array[k] = tmp[j];
                j++;
            } else if (j > high) {
                array[k] = tmp[i];
                i++;
            } else if (tmp[i] > tmp[j]) {
                array[k] = tmp[j];
                j++;
            } else {
                array[k] = tmp[i];
                i++;
            }

        }
    }

    public static void sort(int[] nums, int low, int high)
    {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(nums, low, mid);
        sort(nums, mid + 1, high);
        merge(nums, low, mid, high);

    }

    public static void mergesort(int[] nums)
    {
        sort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] {2, 4, 1, 4, 2};
        mergesort(nums);
        System.out.print(Arrays.toString(nums));

    }

}
