package com.unisound.algorithm.dp;

class Pair
{
    int first;

    int second;

    Pair(int fir, int sec)
    {
        this.first = fir;
        this.second = sec;
    }
}

public class StoneGameOrCoinGame
{
    public boolean stoneGame(int[] piles)
    {
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];
        // 初始化dp数组
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = new Pair(0, 0);

            }
        }

        // 填入base case
        for (int i = 0; i < n; i++) {
            dp[i][i].first = piles[i];
            dp[i][i].second = 0;
        }

        // 斜着遍历dp数组
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l; i++) {
                int j = l + i - 1;

                // 先手在做出选择之后，就成了后手，后手在对方做完选择后，就变成了先手
                // 先拿的选择右边或者左边
                // i，j代表左边那堆石头，和右边那堆石头
                int left = piles[i] + dp[i + 1][j].second; // dp[i + 1][j].second; 先拿的拿左边的话，剩下dp[i +
                                                           // 1][j]，此时相当于后拿的sencond ,所以piles[i]现在准备在左边拿的 + dp[i +
                                                           // 1][j].second就是此时先拿左边的最大石头数
                int right = piles[j] + dp[i][j - 1].second;

                // 选择， 选择左边 还是右边
                if (left > right) {
                    dp[i][j].first = left;
                    // 当拿完左边的时候，剩下dp[i + 1][j], 这个时候后拿的状态还没去拿，此时后拿变成先拿， 但是此时等于拿完左边后的状态即dp[i + 1][j].first
                    dp[i][j].second = dp[i + 1][j].first;
                } else {
                    dp[i][j].first = right;
                    dp[i][j].second = dp[i][j - 1].first;
                }

            }
        }

        Pair res = dp[0][n - 1];

        return res.first - res.second >= 0;

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
