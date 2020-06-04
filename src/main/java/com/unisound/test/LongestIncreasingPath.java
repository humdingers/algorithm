package com.unisound.test;

/*
 * 329. 矩阵中的最长递增路径
给定一个整数矩阵，找出最长递增路径的长度。

对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。

示例 1:

输入: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
输出: 4 
解释: 最长递增路径为 [1, 2, 6, 9]。

 */
public class LongestIncreasingPath
{
    private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix)
    {
        int row = matrix.length;
        int col = matrix[0].length;

        int ans = 0;

        int[][] cache = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans = Math.max(ans, dfs(matrix, cache, i, j));
            }
        }

        return ans;
    }

    public int dfs(int[][] matrix, int[][] cache, int i, int j)
    {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[i][j] < matrix[x][y]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, cache, x, y));
            }

        }

        return ++cache[i][j];

    }

}
