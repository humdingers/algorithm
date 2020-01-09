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

public class SuperEggDropSearch
{

    Integer[][] memo;

    public int superEggDrop(int K, int N)
    {
        memo = new Integer[K][N];

        return dp(K, N);

    }

    // 二分查找来优化线性搜索的复杂； 0-N线性搜索
    public int dp(int K, int N)
    {

        if (K == 1)
            return N;
        if (N == 0)
            return 0;

        int lo = 0;
        int hi = N;

        int res = N;
        // dp(K - 1, i - 1)和dp(K, N - i)这两个函数，其中i是从 1
        // 到N单增的，如果我们固定K和N，把这两个函数看做关于i的函数，前者随着i的增加应该也是单调递增的，而后者随着i的增加应该是单调递减的：

        // 求二者的较大值，再求这些最大值之中的最小值，其实就是求这两条直线交点
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int broken = dp(K - 1, mid - 1); // 碎的情况（状态），k-1， 1到mid-1搜索

            int not_broken = dp(K, N - mid);// 没碎的情况（状态），k不变， mid+1到N搜索

            if (broken > not_broken) {
                hi = mid - 1;
                res = Math.min(res, broken + 1); // 此时broken的情况最坏，需要加上刚刚扔的这次，等于此时的尝试次数
            } else {
                lo = mid + 1;
                res = Math.min(res, not_broken + 1);
            }

        }

        memo[K][N] = res;

        return res;

    }

}
