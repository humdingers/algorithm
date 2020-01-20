package com.unisound.dp;

//石子游戏
/*
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。

    游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
    
    亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
    
    假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
    
     
    
    示例：
    
    输入：[5,3,4,5]
    输出：true
    解释：
    亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
    假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
    如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
    如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
    这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。


 */
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
        // 初始化dp数组 代表第i----j堆石头此时最佳的拿法
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = new Pair(0, 0);

            }
        }

        // 填入base case 面前只有一堆石头时，先手的得分就是这堆石头，后手为0
        for (int i = 0; i < n; i++) {
            dp[i][i].first = piles[i];
            dp[i][i].second = 0;
        }

        // 斜着遍历dp数组
        for (int i = n - 2; i <= 0; i++) {
            for (int j = i + 1; j < n; j++) {

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
