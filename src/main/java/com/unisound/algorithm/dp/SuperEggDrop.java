package com.unisound.algorithm.dp;

//鸡蛋掉落
/*
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。

每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。

你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。

每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。

你的目标是确切地知道 F 的值是多少。

无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？

 

示例 1：

输入：K = 1, N = 2
输出：2
解释：
鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
如果它没碎，那么我们肯定知道 F = 2 。
因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 */
public class SuperEggDrop
{
    Integer[][] memo;

    public int superEggDrop(int K, int N)
    {
        memo = new Integer[K + 1][N + 1];
        return dp(K, N);
    }

    public int dp(int K, int N)
    {
        if (K == 1)
            return N;

        if (N == 0)
            return 0;

        if (memo[K][N] != null) {
            return memo[K][N];
        }

        int res = N;
        /*
         * 1、暴力穷举尝试在所有楼层1 <= i <= N扔鸡蛋，每次选择尝试次数最少的那一层； 2、每次扔鸡蛋有两种可能，要么碎，要么没碎； 3、如果鸡蛋碎了，F应该在第i层下面，否则，F应该在第i层上面；
         * 4、鸡蛋是碎了还是没碎，取决于哪种情况下尝试次数更多，因为我们想求的是最坏情况下的结果
         */

        for (int i = 1; i < N + 1; i++) {
            // 每个状态里每层楼都扔一次，取碎与没碎两种情况，尝试最多的（最坏的情况），然后选择扔的那层尝试次数最少的
            // 这一层，碎与没碎两种情况，最坏的情况下次数，然后选择所有层尝试次数最少的那一层
            res = Math.min(res, Math.max(dp(K, N - i), dp(K - 1, i - 1)) + 1); // 两个dp代表碎与没碎，加1 是在第 i 楼扔了一次

        }

        memo[K][N] = res;

        return res;

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
