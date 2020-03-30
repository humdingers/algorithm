package com.unisound.sort;

import java.util.Arrays;

public class BubleSort
{
    public static void sort(int[] nums)
    {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;

                }
            }

        }
    }

    public static void sort_plus1(int[] nums)
    {

        for (int i = 0; i < nums.length - 1; i++) {
            boolean isSorted = true; // 判断是否有序
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                    isSorted = false; // 如果有交换，说明不是有序的

                }
            }

            if (isSorted) {
                break;
            }

        }
    }

    public static void sort_plus3(int[] nums)
    {
        int sortBoarder = nums.length;
        int lastExchange = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isSorted = true; // 判断是否有序
            for (int j = 1; j < sortBoarder; j++) {
                if (nums[j - 1] > nums[j]) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;

                    isSorted = false; // 如果有交换，说明不是有序的
                    lastExchange = j;

                }
            }

            sortBoarder = lastExchange;

            if (isSorted) {
                break;
            }

        }
    }

    public static void sort_plus2(int[] nums)
    {
        int sortBoarder = nums.length - 1;
        int lastExchange = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isSorted = true; // 判断是否有序
            for (int j = 0; j < sortBoarder; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;

                    isSorted = false; // 如果有交换，说明不是有序的的
                    lastExchange = j;

                }
            }

            sortBoarder = lastExchange;

            if (isSorted) {
                break;
            }

        }
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] {2, 5, 4, 1, 4, 2};
        // sort(nums);
        sort_plus3(nums);
        System.out.print(Arrays.toString(nums));

    }

}
