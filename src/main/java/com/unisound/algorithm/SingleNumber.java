package com.unisound.algorithm;

import java.util.HashMap;
import java.util.Map;

// 只出现一次的数字 III
/*
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。

    示例 :
    
    输入: [1,2,1,3,2,5]
    输出: [3,5]

 */
public class SingleNumber
{
    public int[] singleNumber(int[] nums)
    {
        Map<Integer, Integer> hashmap = new HashMap();
        for (int n : nums)
            hashmap.put(n, hashmap.getOrDefault(n, 0) + 1);

        int[] output = new int[2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> item : hashmap.entrySet())
            if (item.getValue() == 1)
                output[idx++] = item.getKey();

        return output;
    }

}
