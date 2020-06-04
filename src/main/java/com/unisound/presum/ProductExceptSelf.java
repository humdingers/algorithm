package com.unisound.presum;

/*
 * 238. 除自身以外数组的乘积
给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

 

示例:

输入: [1,2,3,4]
输出: [24,12,8,6]
 

提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

进阶：
 */
//时间复杂度：O(N) 空间复杂度 O(1)

//乘积 = 当前数左边的乘积 * 当前数右边的乘积
public class ProductExceptSelf
{
    public int[] productExceptSelf(int[] nums)
    {
        int len = nums.length;

        int res[] = new int[len];
        // res[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 res[0] = 1

        res[0] = 1;

        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1

        int R = 1;

        for (int i = len - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 res[i]，右边的乘积为 R
            res[i] = res[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }

        return res;

    }

}
