package com.unisound.sort;

import java.util.Arrays;

public class quick_sort
{
    public static void quicksort(int[] arr, int startIndex, int endIndex)
    {
        if (startIndex >= endIndex) {
            return;
        }
        int privotIndex = partition(arr, startIndex, endIndex);

        quicksort(arr, startIndex, privotIndex - 1);
        quicksort(arr, privotIndex + 1, endIndex);
    }

    public static int partition(int arr[], int startIndex, int endIndex)
    {
        int privot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < privot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = privot;

        return mark;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[] {4, 4, 6, 5, 3, 2, 8, 1};
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

}
