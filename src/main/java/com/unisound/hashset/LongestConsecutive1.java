package com.unisound.hashset;

import java.util.HashSet;
import java.util.Set;

/*
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
    
    要求算法的时间复杂度为 O(n)。
    
    示例:
    
    输入: [100, 4, 200, 1, 3, 2]
    输出: 4
    解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class LongestConsecutive1
{
    // 最长连续序列
    public int longestConsecutive(int[] nums)
    {
        Set<Integer> tmp = new HashSet<Integer>();
        for (int num : nums) {
            tmp.add(num);
        }

        int res = 0;

        for (int num : tmp) {
            // 我们只对 当前数字 - 1 不在哈希表里的数字，作为连续序列的第一个数字去找对应的最长序列，这是因为其他数字一定已经出现在了某个序列里。

            if (!tmp.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (tmp.contains(currentNum + 1)) {
                    currentNum += 1;
                    count += 1;
                }

                res = Math.max(count, res);

            }
        }

        return res;

    }

}
