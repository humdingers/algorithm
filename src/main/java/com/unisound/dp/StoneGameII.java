package com.unisound.dp;

//石子游戏
/*
 * 亚历克斯和李继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。

    亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。
    
    在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
    
    游戏一直持续到所有石子都被拿走。
    
    假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。
    
     
    
    示例：
    
    输入：piles = [2,7,9,4,4]
    输出：10
    解释：
    如果亚历克斯在开始时拿走一堆石子，李拿走两堆，接着亚历克斯也拿走两堆。在这种情况下，亚历克斯可以拿到 2 + 4 + 4 = 10 颗石子。 
    如果亚历克斯在开始时拿走两堆石子，那么李就可以拿走剩下全部三堆石子。在这种情况下，亚历克斯可以拿到 2 + 7 = 9 颗石子。
    所以我们返回更大的 10。 
     
    
    提示：
    
    1 <= piles.length <= 100
    1 <= piles[i] <= 10 ^ 4

 */
public class StoneGameII
{
    private int[][] memo;

    public int stoneGameII(int[] piles)
    {
        if (piles == null || piles.length == 0)
            return 0;

        int n = piles.length;
        memo = new int[n][n];

        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        return dp(piles, 0, 1, suffixSum);

    }

    public int dp(int[] piles, int i, int M, int[] suffixSum)
    {
        if (i == piles.length)
            return 0;

        // 该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。
        // 当前可以拿的堆数超过piles时，剩下的都可以拿w
        if (i + 2 * M >= piles.length) {
            return suffixSum[i];
        }

        if (memo[i][M] != 0) {
            return memo[i][M];
        }

        int minOther = Integer.MAX_VALUE;
        // 先取 1 <= X <= 2M 堆石子。假设Alex取X堆石子，那么对于剩下的石子，
        // Lee也想拿到数量最多的石子，所以对剩下的石子同样用findMaxStone求出最多可以拿到的石子数。
        // 那么，每个X均对应一个"Lee最多可以拿到的石子数"，只要找到某一X，使得Lee的石子数最少，这时Alex的石子数最大。

        for (int X = 1; X <= 2 * M; X++) {
            minOther = Math.min(minOther, dp(piles, i + X, Math.max(X, M), suffixSum));

        }
        memo[i][M] = suffixSum[i] - minOther;
        return memo[i][M];

    }

}
