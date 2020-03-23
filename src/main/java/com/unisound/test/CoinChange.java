package com.unisound.test;

import java.util.Arrays;

//零钱兑换
/*
* 给定不同面额的硬币 coins 和一个总金额 amount。
* 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

      示例 1:
      
      输入: coins = [1, 2, 5], amount = 11
      输出: 3 
      解释: 11 = 5 + 5 + 1
*/
/*
* 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 

 

      示例 1:
      
      输入: amount = 5, coins = [1, 2, 5]
      输出: 4
      解释: 有四种方式可以凑成总金额:
      5=5
      5=2+2+1
      5=2+1+1+1
      5=1+1+1+1+1

*/

public class CoinChange
{
    public int coinChange(int[] coins, int amount)
    {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }

        }

        return dp[amount] > amount ? -1 : dp[amount];

    }

    public int change(int amount, int[] coins)
    {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }

        return dp[amount];

    }

}
