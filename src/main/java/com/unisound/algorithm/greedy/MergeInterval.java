package com.unisound.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

// 合并区间
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
