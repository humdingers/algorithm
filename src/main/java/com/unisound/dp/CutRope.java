package com.unisound.dp;

//剪绳子
/*
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutRope
{
    public int cutRope(int n)
    {

        if (n == 2) {
            return 1;
        }

        // 虽然n=3时乘积最大值为3，但是题目要求必须分割，所以当做特殊情况来表示
        if (n == 3) {
            return 2;
        }

        int[] dp = new int[n + 1];

        // 区别上面的n的特殊情况
        // 此时base case, 为i当前值时乘积的最大值，当超过4的时候乘积就不是自身了
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        int res = 0;

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                res = Math.max(res, dp[j] * dp[i - j]);
            }

            dp[i] = res;
        }

        return dp[n];

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
