package com.unisound.test;

/*
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
 */

public class OrdEvenSort
{
    private static void mysort(int[] array)
    {
        if (array == null) {
            return;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            while (left < right && !isEven(array[left])) {
                left++;
            }

            while (left < right && isEven(array[right])) {
                right--;
            }

            if (left < right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }

            if (left >= right) {
                break;
            }

        }

    }

    private static boolean isEven(int i)
    {
        return (i & 0x1) == 0;
    }

}
