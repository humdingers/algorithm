package com.unisound.algorithm.dp;

import java.util.List;

//三角形最小路径和
/*
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
    
    例如，给定三角形：
    
    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
    自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）

 */

public class MinimumTotal
{
    // 从底向上寻找，最终状态就是顶尖位置，从上向下不太好找
    public int minimumTotal(List<List<Integer>> triangle)
    {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        List<Integer> lastRow = triangle.get(n - 1);

        // base case, 最底层直接赋值
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = lastRow.get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < i + 1; j++) {
                // 从下一行相邻位置寻找最小路径，加上当前路径值
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + row.get(j);
            }
        }

        return dp[0][0];

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
