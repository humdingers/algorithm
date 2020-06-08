package com.unisound.dp;

/*
 * 376. 摆动序列
    如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
    
    例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
    
    给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
    
    示例 1:
    
    输入: [1,7,4,9,2,5]
    输出: 6 
    解释: 整个序列均为摆动序列
 */
public class WiggleMaxLength
{
    public int wiggleMaxLength(int[] nums)
    {
        if (nums.length < 2) {
            return nums.length;
        }

        int[] up = new int[nums.length];

        int[] down = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }
        }

        return Math.max(up[nums.length - 1], down[nums.length - 1]) + 1;

    }

    /**
     * dp[n][m]，m表示最后一个差值的状态，0表示为负数，1表示为正数， 那么状态转移方程就出来了 差值为负数 dp[n][0] = max(dp[n-1][1]+1, dp[n-1][0]); 差值为正数 dp[n][1]
     * = max(dp[n-1][0]+1, dp[n-1][1]); 当差值为0时，维持上一个数的状态，即: dp[n][0] = dp[n-1][0]; dp[n][1] = dp[n-1][1];
     * 
     * @param nums
     * @return
     */

    public static int wiggleMaxLength1(int[] nums)
    {
        if (nums == null || nums.length < 2) {
            return nums == null ? 0 : nums.length;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                dp[i][1] = Math.max(dp[i - 1][0] + 1, dp[i - 1][1]);
            } else if (nums[i] - nums[i - 1] < 0) {
                dp[i][0] = Math.max(dp[i - 1][1] + 1, dp[i - 1][0]);
            } else {
                dp[i][1] = dp[i - 1][1];
                dp[i][0] = dp[i - 1][0];
            }
        }

        System.out.println(dp.length - 1);
        return Math.max(dp[dp.length - 1][1], dp[dp.length - 1][0]);
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] {1, 7, 4, 9, 2, 5};
        System.out.print(wiggleMaxLength1(nums));

    }

}
