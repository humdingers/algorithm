package com.unisound.presum;

//有n个硬币排成一排，每次要你从最左边或者最右侧拿出一个硬币。总共拿k次。
//写一个算法，使能拿到的硬币的和最大。
public class GetKCoins
{
    public static int takeCoins(int[] list, int k)
    {
        int n = list.length;
        int[] preSum = new int[n + 1];

        int res = 0;

        // 这个前缀和数组preSum的含义也很好理解，preSum[i]就是nums[0..i-1]的和。
        // 那么如果我们想求nums[i..j]的和，只需要一步操作preSum[j+1]-preSum[i]即可，而不需要重新去遍历数组了。

        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + list[i];
        }

        for (int i = 0; i <= k; i++) {
            // 遍历搜索左边拿多少次和右边拿多少次哪个更合适
            int left = i;
            int right = k - i;

            int cur = preSum[n] - preSum[n - right] + preSum[left];
            res = Math.max(res, cur);

        }

        return res;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] {5, 1, 2, 3, 4};
        System.out.print(takeCoins(nums, 3));

    }

}
