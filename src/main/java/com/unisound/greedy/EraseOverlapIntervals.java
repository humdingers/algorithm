package com.unisound.greedy;

import java.util.Arrays;
import java.util.Comparator;

//区间调度问题
public class EraseOverlapIntervals
{
    // 最多不重叠区间数量
    public int intervalSchedule(int[][] intvs)
    {
        if (intvs.length == 0)
            return 0;
        // 按end排序
        Arrays.sort(intvs, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b)
            {
                return a[1] - b[1];
            }
        });

        int count = 1;
        int end = intvs[0][1];

        for (int[] intv : intvs) {
            int start = intv[0];
            if (start >= end) {
                count += 1;
                end = intv[1];
            }
        }

        return count;

    }

    // 无重叠区间
    public int eraseOverlapIntervals(int[][] intervals)
    {
        int n = intervals.length;
        return n - intervalSchedule(intervals);

    }

}
