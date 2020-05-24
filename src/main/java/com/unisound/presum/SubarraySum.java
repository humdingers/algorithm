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
        Map<Integer, Integer> tmp = new HashMap<Integer, Integer>();

        tmp.put(0, 1);
        // sum-k + k = sum， sum-k
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (tmp.containsKey(sum - k)) {
                count += tmp.get(sum - k);
            }

            tmp.put(sum, tmp.getOrDefault(sum, 0) + 1);
        }

        return count;

    }
}
