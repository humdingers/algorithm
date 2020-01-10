package com.unisound.dp;

//最大正方形
/*
     * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
    
    示例:
    
    输入: 
    
    1 0 1 0 0
    1 0 1 1 1
    1 1 1 1 1
    1 0 0 1 0
    
    输出: 4

 */
public class MaximalSquare
{
    public int maximalSquare(char[][] matrix)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int dp[][] = new int[m][n];

        int max_length = 0;

        // 以正方形的右下方点为当前状态，往 上方、左方、左上方 方向寻找合适的可以与当前点构成正方形的点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == '1') {
                    // base case 上边界和左边界的为“1”的初始值为1，因为没有上方、左方、左上方
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;

                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;

                    }
                }

                max_length = Math.max(max_length, dp[i][j]);
            }

        }

        return max_length * max_length;

    }

}
