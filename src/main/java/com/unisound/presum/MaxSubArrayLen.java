package com.unisound.presum;

import java.util.HashMap;
import java.util.Map;

/*
 * 给定一个数组nums和一个目标值k，找到一个总和为k的子数组的最大长度。
如果没有，则返回0。

Input: nums = [1, -1, 5, -2, 3], k = 3
Output: 4 
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 */
public class MaxSubArrayLen
{
    public int maxSubArrayLen(int[] nums, int k)
    {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 下标 0 之前的位置是 -1
        map.put(0, -1);

        int presum = 0;
        int res = 0;
        // 把数组中的 0 都看成 -1
        for (int i = 0; i < len; i++) {
            // 把 0 视为 -1，pre 是先加了，所以后面计算的时候是 i - map.get(preSum)，注意下标 + 1 和不加 1 的差别

            presum += nums[i];

            if (map.containsKey(presum - k)) {
                res = Math.max(res, i - map.get(presum));
            }

            if (!map.containsKey(presum)) {
                map.put(presum, i);
            }

        }
        return res;

    }

}
