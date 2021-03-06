package com.unisound.dp;

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

public class SuperEggDropOptimal
{
    public int superEggDrop(int K, int N)
    {
        // 此时的dp数组的含义改变, 确定当前的鸡蛋个数K和最多允许的扔鸡蛋次数m，就知道能够确定F的最高楼层数
        // dp[k][m] = n
        // 当前有 k 个鸡蛋，可以尝试扔 m 次鸡蛋
        // 这个状态下，最坏情况下最多能确切测试一栋 n 层的楼

        // 比如说 dp[1][7] = 7 表示：
        // 现在有 1 个鸡蛋，允许你扔 7 次;
        // 这个状态下最多给你 7 层楼，
        // 使得你可以确定楼层 F 使得鸡蛋恰好摔不碎
        // （一层一层线性探查嘛）
        int[][] dp = new int[K + 1][N + 1];

        int m = 0;

        // 给你K鸡蛋，N层楼，让你求最坏情况下最少的测试次数m 吗？
        // while循环结束的条件是dp[K][m] == N，也就是给你K个鸡蛋，允许测试m次，最坏情况下最多能测试N层楼
        while (dp[K][m] < N) {

            m++; // 遍历求解符合条件的m,dp[k][m] = N;
            for (int k = 1; k <= K; k++) {
                // 1、无论你在哪层楼扔鸡蛋，鸡蛋只可能摔碎或者没摔碎，碎了的话就测楼下，没碎的话就测楼上。
                // 2、无论你上楼还是下楼，总的楼层数 = 楼上的楼层数 + 楼下的楼层数 + 1（当前这层楼）。

                // dp[k][m - 1]就是楼上的楼层数，因为鸡蛋个数k不变，也就是鸡蛋没碎，扔鸡蛋次数m减一；
                // dp[k - 1][m - 1]就是楼下的楼层数，因为鸡蛋个数k减一，也就是鸡蛋碎了，同时扔鸡蛋次数m减一

                // 此时的m是一个允许的次数上界
                dp[k][m] = dp[k - 1][m - 1] + dp[k][m - 1] + 1;
            }

        }

        return m; // 返回符合条件的m

    }

}
