package com.unisound.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目：输入n个整数，输出其中最小的k个。 例如输入1，2，3，4，5，6，7和8这8个数字，则最小的4个数字为1，2，3和4。
 */
public class GetLeastNumbers
{
    public ArrayList<Integer> GetLeastNumbers_Solution_revise(int[] input, int k)
    {

        ArrayList<Integer> result = new ArrayList<Integer>();

        if (input == null || k <= 0 || k > input.length)
            return result;

        for (int i = 0; i <= k - 1; i++) {
            for (int j = i + 1; j <= input.length - 1; j++) {
                if (input[i] > input[j]) {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
            result.add(input[i]);
        }

        return result;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if (k > length || k == 0) {
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>()
        {
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }

    public ArrayList<Integer> GetLeastNumbers_sort(int[] input, int k)
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int len = input.length;
        if (k > len)
            return arr;
        for (int i = 0; i < k; i++) {
            heapsort(input, i, len);
            arr.add(input[i]);
        }
        return arr;
    }

    void heapsort(int[] input, int i, int len)
    {
        for (int j = len - 1; j >= i; j--) {
            int p = (j + i - 1) / 2;
            if (input[p] > input[j]) {
                int temp = input[p];
                input[p] = input[j];
                input[j] = temp;
            }

        }

    }
}
