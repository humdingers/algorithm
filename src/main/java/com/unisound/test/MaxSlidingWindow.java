package com.unisound.test;

import java.util.ArrayDeque;

//滑动窗口最大值
/*
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 返回滑动窗口中的最大值。 示例: 输入: nums =
 * [1,3,-1,-3,5,3,6,7], 和 k = 3 输出: [3,3,5,5,6,7]
 */
class MonotonicQueue
{
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();

    void push(int n)
    {
        while (!deq.isEmpty() && deq.getLast() < n) {
            deq.removeLast();
        }

        deq.addLast(n);
    }

    int max()
    {
        return deq.getFirst();
    }

    void pop(int n)
    {
        while (!deq.isEmpty() && deq.getFirst() == n) {
            deq.removeFirst();
        }
    }

}

public class MaxSlidingWindow
{

    public int[] maxSlidingWindow(int[] nums, int k)
    {
        int n = nums.length;

        if (n * k == 0) {
            return new int[] {};
        }

        if (k == 1) {
            return nums;
        }

        MonotonicQueue window = new MonotonicQueue();

        int[] res = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                window.push(n);
            } else {
                window.push(n);
                res[i - k + 1] = window.max();
                window.pop(n);
            }

        }

        return res;

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
