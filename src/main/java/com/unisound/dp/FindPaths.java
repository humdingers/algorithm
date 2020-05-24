package com.unisound.dp;

/*
 * 576. 出界的路径数
    给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，
    你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。
    但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。

 

示例 1：

输入: m = 2, n = 2, N = 2, i = 0, j = 0
输出: 6
解释:

 */

/*
 * dp[i][j][k]:表示从(i,j)出发第k步出界的路径总数，等价于从外界出发第k步走到(i,j)的路径总数
 * 有了每一个点的每一步对应的值，我们可以说是什么都不怕了
题目求的是最多移动N次，出界的路径数，因此我们只需要讲每一步对应的值都加起来即可

Sum = sum dp[i][j][k]


 */
public class FindPaths
{

    public int findPaths(int m, int n, int N, int i, int j)
    {
        int MOD = 1000000007;
        if (N == 0) {
            return 0;
        }

        // long型防止数据溢出
        long[][][] dp = new long[m + 2][n + 2][N + 1];

        // 四周扩大范围，加了边界
        // 从外界某一点走0步到达i,j的路径数
        for (int r = 0; r <= m + 1; r++) {
            dp[r][0][0] = 1;
            dp[r][n + 1][0] = 1;
        }

        for (int c = 0; c <= n + 1; c++) {
            dp[0][c][0] = 1;
            dp[m + 1][c][0] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int r = 1; r <= m; r++) {
                for (int c = 1; c <= n; c++) {

                    dp[r][c][k] =
                        (dp[r - 1][c][k - 1] + dp[r][c - 1][k - 1] + dp[r + 1][c][k - 1] + dp[r][c + 1][k - 1]) % MOD;
                }
            }
        }

        int sum = 0;

        // 根据生成的记忆矩阵，累加每一种可能
        for (int k = 1; k <= N; k++) {

            sum = (int) ((sum + dp[i + 1][j + 1][k]) % MOD);
        }

        return sum;

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
