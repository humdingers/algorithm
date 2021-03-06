package com.unisound.test;
/*
 * 1248. 统计「优美子数组」
    给你一个整数数组 nums 和一个整数 k。
    
    如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
    
    请返回这个数组中「优美子数组」的数目。
    
     
    
    示例 1：
    
    输入：nums = [1,1,2,1,1], k = 3
    输出：2
    解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
    示例 2：
    
    输入：nums = [2,4,6], k = 1
    输出：0
解释：数列中不包含任何奇数，所以不存在优美子数组。
 */

/*
 * 这个题目中偶数其实是没有用的，我们可以单独建立一个 odd 数组来记录第 i 个奇数的下标。
 * 那么我们可以枚举奇数，假设当前枚举到第 i 个，那么[odd[i],odd[i+k−1]] 这个子数组就恰好包含 k 个奇数。
 * 由于奇数和奇数间存在偶数，所以一定存在其他子数组 [l,r] 满足 [l,r]包含 [odd[i],odd[i+k−1]] 且 [l,r]里的奇数个数为 k 个，那么这个需要怎么统计呢？

由于我们已经记录了每个奇数的下标，所以我们知道对于第 i个奇数，它的前一个奇数的下标为 odd[i−1]，也就是说 (odd[i−1],odd[i]) 间的数都为偶数
同理可得 (odd[i+k−1],odd[i+k]) 间的数也都为偶数。
那么我们可以得出满足 l∈(odd[i−1],odd[i]] 且 r∈[odd[i+k−1],odd[i+k]) 条件的子数组 [l,r]
 包含 [odd[i],odd[i+k−1]] 且 [l,r]里的奇数个数为 k 个。
 因此对于第 i 个奇数，它对答案的贡献为符合条件的 [l,r] 的个数，即：

(odd[i]−odd[i−1])∗(odd[i+k]−odd[i+k−1])

 */

public class NumberOfSubarrays
{
    public int numberOfSubarraysMath(int[] nums, int k)
    {
        int res = 0;
        int ordcount = 0;
        int len = nums.length;

        int[] arrord = new int[len + 2];

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                ordcount += 1;
                arrord[ordcount] = i;
            }
        }

        arrord[0] = -1;
        arrord[len + 1] = len;

        for (int i = 1; i + k < ordcount + 2; i++) {
            res += (arrord[i] - arrord[i - 1]) * (arrord[i + k] - arrord[i + k - 1]);

        }

        return res;
    }

}
