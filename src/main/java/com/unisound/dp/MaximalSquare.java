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
/*
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。

 

示例 1：

输入：matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
输出：15
解释： 
边长为 1 的正方形有 10 个。
边长为 2 的正方形有 4 个。
边长为 3 的正方形有 1 个。
正方形的总数 = 10 + 4 + 1 = 15.
示例 2：

输入：matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
输出：7
解释：
边长为 1 的正方形有 6 个。 
边长为 2 的正方形有 1 个。
正方形的总数 = 6 + 1 = 7.

 */

/*
 * 我们用 f[i][j] 表示以 (i, j) 为右下角的正方形的最大边长，那么除此定义之外，f[i][j] = x 也表示以 (i, j) 为右下角的正方形的数目为 x（即边长为 1, 2, ..., x 的正方形各一个）。
 * 在计算出所有的 f[i][j] 后，我们将它们进行累加，就可以得到矩阵中正方形的数目
 */
/*
 * 此时nums+dp[i][j],解释原因例如：
如果dp[i][j]=3，那么以dp[i][j]该点为正方形的右下角，存在一个边长为3的正方形，同时，边长为3的正方形会包含一个边长比它小的正方形，故在dp[i][j]处还能取到边长为2，边长为1的正方形，故该点能取边长为 1,2,3的三个正方形，故nums+dp[i][j]
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

    public int countSquares(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int dp[][] = new int[m][n];

        int res = 0;

        // 以正方形的右下方点为当前状态，往 上方、左方、左上方 方向寻找合适的可以与当前点构成正方形的点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 1) {
                    // base case 上边界和左边界的为“1”的初始值为1，因为没有上方、左方、左上方
                    if (i == 0 || j == 0) {
                        dp[i][j] = matrix[i][j];

                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;

                    }
                }

                res += dp[i][j];
            }

        }

        return res;

    }

}
