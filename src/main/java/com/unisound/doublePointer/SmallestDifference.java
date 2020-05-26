package com.unisound.doublePointer;

import java.util.Arrays;

/*
 * 面试题 16.06. 最小差
给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差

示例：

输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
输出： 3，即数值对(11, 8)
 */
public class SmallestDifference
{
    public int smallestDifference(int[] a, int[] b)
    {

        Arrays.sort(a);
        Arrays.sort(b);
        long res = Long.MAX_VALUE;
        int n = a.length, m = b.length;
        int i = 0, j = 0;

        while (i < n && j < m) {
            res = Math.min(res, Math.abs((long) a[i] - (long) b[j]));
            if (a[i] > b[j])
                ++j;
            else
                ++i;
        }
        return (int) res;
    }

}
