package com.unisound.dp;

/*
 * 1186. 删除一次得到子数组最大和
给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。

换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。

注意，删除一个元素后，子数组 不能为空。

请看示例：

示例 1：

输入：arr = [1,-2,0,3]
输出：4
解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。
示例 2：

输入：arr = [1,-2,-2,3]
输出：3
解释：我们直接选出 [3]，这就是最大和
 */
public class MaximumSum
{
    public int maximumSum(int[] arr)
    {
        int len = arr.length;
        int[] f = new int[len];
        int[] g = new int[len];
        f[0] = arr[0];
        g[0] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            f[i] = Math.max(f[i - 1] + arr[i], arr[i]);// 其实就是f(i-1)是否<0
            g[i] = Math.max(g[i - 1] + arr[i], f[i - 1]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, Math.max(f[i], g[i]));
        }
        return res;
    }

    public int maximumSum1(int[] arr)
    {
        int n = arr.length;
        int ans = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = arr[0];
        right[n - 1] = arr[n - 1];
        ans = Math.max(left[0], right[n - 1]);

        // 前缀和
        for (int i = 1; i < n; ++i) {
            left[i] = arr[i] + Math.max(0, left[i - 1]);
            ans = Math.max(ans, left[i]);
        }
        // 后缀和
        for (int i = n - 2; i >= 0; --i) {
            right[i] = arr[i] + Math.max(0, right[i + 1]);
            ans = Math.max(ans, right[i]);
        }
        for (int i = 1; i <= n - 2; ++i) {
            ans = Math.max(ans, left[i - 1] + right[i + 1]);
        }

        return ans;
    }

}
