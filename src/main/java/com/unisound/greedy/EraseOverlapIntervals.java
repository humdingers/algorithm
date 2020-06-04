package com.unisound.greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 435. 无重叠区间
给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

注意:

可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
示例 1:

输入: [ [1,2], [2,3], [3,4], [1,3] ]

输出: 1

解释: 移除 [1,3] 后，剩下的区间没有重叠。
示例 2:

输入: [ [1,2], [1,2], [1,2] ]

输出: 2

解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 */
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
