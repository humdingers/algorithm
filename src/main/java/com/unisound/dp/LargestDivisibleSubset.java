package com.unisound.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 368. 最大整除子集
    给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
    
    如果有多个目标子集，返回其中任何一个均可。
    
     
    
    示例 1:
    
    输入: [1,2,3]
    输出: [1,2] (当然, [1,3] 也正确)
    示例 2:
    
    输入: [1,2,4,8]
    输出: [1,2,4,8]
 */
/*
 * 对于已经排序后的nums
设定状态: dp[i]: 包含nums[i]在内的前i个元素的最大整除子集的元素个数
last[i]: 在最大序列中 nums[i]的上一个元素在nums出现的下标 ,这个最大个数是由上一个哪个子集+1得来的
状态转移方程：
使用二重循环,对于每一个nums[i]，看他可以接在之前的哪个序列dp[j]上，使得dp[i]最长
nums[i]%nums[j] == 0是可以接的条件，dp[i]<=dp[j]是使得dp[i]变长的条件
初始状态：dp[i] = 1  每一个只有自己的序列长度为1
 */
//O(n^2)
public class LargestDivisibleSubset
{
    public List<Integer> largestDivisibleSubset(int[] nums)
    {
        List<Integer> ans = new ArrayList<Integer>();

        int n = nums.length;

        if (n == 0) {
            return ans;
        }

        int[] dp = new int[n];
        int[] last = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(last, -1);

        Arrays.sort(nums);

        for (int i = 1; i < n; i++) {
            for (int k = 0; k < i; k++) {
                if (nums[i] % nums[k] == 0 && dp[i] <= dp[k]) {
                    dp[i] = dp[k] + 1;
                    last[i] = k;

                }

            }

        }

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (dp[i] > dp[index]) {
                index = i;
            }
        }

        while (index != -1) {
            ans.add(nums[index]);
            index = last[index];
        }

        return ans;

    }

}
