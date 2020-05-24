package com.unisound.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

// 合并区间
/*
 * 56. 合并区间
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeInterval
{

    public int[][] merge(int[][] intervals)
    {
        if (intervals == null || intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b)
            {
                return a[0] - b[0];

            }

        });

        Stack<int[]> stack = new Stack<int[]>();

        for (int[] interval : intervals) {
            if (stack.isEmpty()) {
                stack.push(interval);
            } else {
                int[] cur = stack.pop();
                if (cur[1] >= interval[0]) {
                    int[] combine = new int[] {cur[0], Math.max(cur[1], interval[1])};
                    stack.push(combine);
                } else {
                    stack.push(cur);
                    stack.push(interval);
                }

            }

        }

        return stack.toArray(new int[0][0]);

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
