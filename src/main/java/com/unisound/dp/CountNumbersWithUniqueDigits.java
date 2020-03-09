package com.unisound.dp;

// 计算各个位数不同的数字个数

/*
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。

    示例:
    
    输入: 2
    输出: 91 
    解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。

 */

/*
 * dp[i]表示增加长度为i位的数字一共有多少不同的数。
转移矩阵：
dp[i] = dp[i - 1] * (10 - (i - 1))

新增第i位时，长度为i位的所有数字不同的个数 = 长度为i-1位所有数字不同的个数 * 剩余可供选择的个数；
类似10重for循环遍历；

dp[0] = 1;
dp[1] = 9(原因是0不能作为首字母被选择,所以dp实际表示的有多少种不同排列的数字，而不是数字组合)
dp[2] = 9x9
dp[3] = 9x9x8
dp[4] = 9x9x8x7
dp[5] = 9x9x8x7x6
dp[6] = 9x9x8x7x6x5
dp[7] = 9x9x8x7x6x5x4
dp[8] = 9x9x8x7x6x5x4x3
dp[9] = 9x9x8x7x6x5x4x3x2
dp[10] = 9x9x8x7x6x5x4x3x2x1

 */
public class CountNumbersWithUniqueDigits
{
    public int countNumbersWithUniqueDigits(int n)
    {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 10;
        }

        if (n > 10) {
            n = 10;
        }

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 9;

        int sum = dp[0] + dp[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * (11 - i);

            sum += dp[i];

        }

        return sum;

    }

}
