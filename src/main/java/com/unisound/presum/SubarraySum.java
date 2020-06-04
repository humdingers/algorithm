package com.unisound.presum;

import java.util.HashMap;
import java.util.Map;

/*
 * 560. 和为K的子数组
    给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
    
    示例 1 :
    
    输入:nums = [1,1,1], k = 2
    输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 */
/*
 * 计算完包括了当前数前缀和以后，我们去查一查在当前数之前，有多少个前缀和等于 preSum - k 呢？
这是因为满足 preSum - (preSum - k) == k 的区间的个数是我们所关心的。

对于一开始的情况，下标 0 之前没有元素，可以认为前缀和为 0，个数为 1 个，因此 preSumFreq.put(0, 1);，这一点是必要且合理的。

 */
public class SubarraySum
{
    public int subarraySum(int[] nums, int k)
    {
        int count = 0;

        int[] sum = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (sum[end] - sum[start] == k) {
                    count++;
                }
            }
        }
        return count;

    }

    public int subarraySumMap(int[] nums, int k)
    {
        int count = 0;
        int sum = 0;
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> tmp = new HashMap<Integer, Integer>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        tmp.put(0, 1);
        // sum-k + k = sum， sum-k
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (tmp.containsKey(sum - k)) {
                count += tmp.get(sum - k);
            }

            tmp.put(sum, tmp.getOrDefault(sum, 0) + 1);
        }

        return count;

    }
}
