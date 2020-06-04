package com.unisound.test;

/*
 * 60. 第k个排列
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:

输入: n = 3, k = 3
输出: "213"
示例 2:

输入: n = 4, k = 9
输出: "2314"
 */
//时间复杂度：O(N^2) 空间O(N)
/*
 * 、我们知道所求排列一定在叶子结点处得到。事实上，进入每一个分支的时候，我们都可以通过递归的层数，直接计算这一分支可以得到的叶子结点的个数；

这是因为：进入一个分支的时候，我们可以根据已经选定的数的个数，进而确定还未选定的数的个数，然后计算阶乘，就知道这一个分支的叶子结点有多少个。

2、如果 k 大于这一个分支将要产生的叶子结点数，直接跳过这个分支，这个操作叫“剪枝”；

3、如果 k 小于等于这一个分支将要产生的叶子结点数，那说明所求的全排列一定在这一个分支将要产生的叶子结点里，需要递归求解；

4、计算阶乘的时候，你可以使用循环计算，特别注意：0!=1，它表示了没有数可选的时候，即表示到达叶子结点了，排列数只剩下 1 个

 */
import java.util.ArrayList;
import java.util.List;

public class GetPermutation
{
    public String getPermutation(int n, int k)
    {
        int[] fac = new int[n + 1];

        fac[0] = 1;

        for (int i = 1; i <= n; i++) {
            fac[i] = fac[i - 1] * i;

        }

        boolean[] used = new boolean[n + 1];

        List<Integer> track = new ArrayList<Integer>();

        backpack(fac, used, track, n, k, 0);

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < track.size(); i++) {
            res.append(track.get(i));
        }

        return res.toString();

    }

    public void backpack(int[] fac, boolean[] used, List<Integer> track, int n, int k, int start)
    {
        if (start == n || track.size() == n) {
            return;
        }

        int count = fac[n - 1 - start];

        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }

            if (count < k) {
                k -= count;
                continue;
            }

            track.add(i);
            used[i] = true;
            backpack(fac, used, track, n, k, start + 1);

        }

    }

}
