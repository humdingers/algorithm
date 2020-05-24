package com.unisound.test;

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
/*
 * 子数组和的最大值可以用典型的lcs。
求删除一个元素后的子数组的最大和，可以用递推公式ans = max(ans,left[i-1] + right[i+1])ans=max(ans,left[i−1]+right[i+1])
left[i]表示从左到右以第i个元素结尾的最大子数组和，right[i]代表从右到左以第i个元素为结尾的最大子数组和.

 */
public class MaximumSum
{
    public int maximumSum(int[] arr)
    {
        int len = arr.length;
        int ans = 0;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = arr[0];
        right[0] = arr[len - 1];

        ans = Math.max(left[0], right[0]);

        for (int i = 1; i < len; i++) {
            left[i] = arr[i] + Math.max(0, left[i - 1]);
            ans = Math.max(left[i], ans);
        }

        for (int i = len - 2; i >= 0; i--) {
            right[i] = arr[i] + Math.max(0, right[i + 1]);
            ans = Math.max(right[i], ans);
        }

        for (int i = 1; i <= len - 2; i++) {
            ans = Math.max(ans, right[i + 1] + left[i - 1]);
        }

        return ans;

    }

}
