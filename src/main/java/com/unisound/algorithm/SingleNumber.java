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
/*
 * 先对所有数字进行一次异或，得到两个出现一次的数字的异或值。

在异或结果中找到任意为 1 的位。

根据这一位对所有的数字进行分组。

在每个组内进行异或操作，得到两个数字

任何数和本身异或则为 0

任何数和 0 异或是 本身

异或满足交换律。 即 a ^ b ^ c ，等价于 a ^ c ^ b

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

    public int[] singleNumbers(int[] nums)
    {
        int ret = 0;

        for (int num : nums) {
            ret ^= num;
        }

        int div = 1;

        while ((div & ret) == 0) {
            div <<= 1;
        }

        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((div & num) == 0) {
                a ^= num;

            } else {
                b ^= num;
            }

        }

        return new int[] {a, b};

    }

}
