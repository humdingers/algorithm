package com.unisound.presum;

import java.util.HashMap;
import java.util.Map;

/*
 * 525. 连续数组
    给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
    
     
    
    示例 1:
    
    输入: [0,1]
    输出: 2
    说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
    示例 2:
    
    输入: [0,1,0]
    输出: 2
    说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 */
public class FindMaxLength
{
    public int findMaxLength(int[] nums)
    {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 下标 0 之前的位置是 -1
        map.put(0, -1);

        int presum = 0;
        int res = 0;
        // 把数组中的 0 都看成 -1
        for (int i = 0; i < len; i++) {
            // 把 0 视为 -1，pre 是先加了，所以后面计算的时候是 i - map.get(preSum)，注意下标 + 1 和不加 1 的差别

            if (nums[i] == 1) {
                presum += 1;
            } else {
                presum -= 1;
            }

            if (map.containsKey(presum)) {
                res = Math.max(res, i - map.get(presum));
            } else {
                // 只记录这个数字第 1 次出现的下标
                map.put(presum, i);
            }

        }
        return res;

    }

}
