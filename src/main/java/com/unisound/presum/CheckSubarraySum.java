package com.unisound.presum;

import java.util.HashSet;
import java.util.Set;

/*
 * 523. 连续的子数组和
给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。

示例 1:

输入: [23,2,4,6,7], k = 6
输出: True
解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
示例 2:

输入: [23,2,6,4,7], k = 6
输出: True
解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 */

//前缀和
/*
 * 我们可以将问题转化为求该数组中是否存在一个长度大于等于 22的子数组，
 * 其中所有数之和可以被 k 整除，即 sum%k=0。对于k=0 的特殊情形，
 * 我们单独讨论。对于求区间和的问题，我们很容易想到利用前缀和数组来优化其查询速度，参考 前缀和。

算法：
预处理数据生成前缀和数组。
遍历查询所有子数组 nums[i:j]的和，并判断它 \%k 是否等于 0，由于题目要求子数组长度大于等于 2，因此需要保证j−i>=2。
对于 k 等于 0 的情形我们进行特判，详情见代码

时间复杂度：O(N^2)
空间复杂度：O(N)
 */
public class CheckSubarraySum
{
    public boolean checkSubarraySum(int[] nums, int k)
    {
        int N = nums.length;

        int[] presum = new int[N + 1];

        for (int i = 0; i < N; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 2; j <= N; j++) {
                int res = presum[j] - presum[i];

                if (k == 0) {
                    if (res == 0) {
                        return true;
                    }
                }

                else {
                    if (res % k == 0) {
                        return true;
                    }
                }

            }
        }

        return false;

    }

    public boolean checkSubarraySumMap(int[] nums, int k)
    {
        int N = nums.length;

        int[] presum = new int[N + 1];

        Set<Integer> tmp = new HashSet<Integer>();

        int cache = 0;

        for (int i = 0; i < N; i++) {
            presum[i + 1] = nums[i] + presum[i];
            int res = k == 0 ? presum[i + 1] : presum[i + 1] % k;

            if (tmp.contains(res)) {
                return true;
            }

            tmp.add(cache);
            cache = res;
        }

        return false;

    }

}
