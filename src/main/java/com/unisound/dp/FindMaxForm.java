package com.unisound.dp;

// 一和零
/*
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。

    现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
    
    你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
    
    注意:
    
    给定 0 和 1 的数量都不会超过 100。
    给定字符串数组的长度不会超过 600。
    示例 1:
    
    输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
    输出: 4
    
    解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。

 */

//时间复杂度：O(mnl)，其中 l 是字符串的个数
public class FindMaxForm
{
    public int findMaxForm(String[] strs, int m, int n)
    {

        // dp(i, j) 表示使用 i 个 0 和 j 个 1，最多能拼出的字符串数目，那么状态转移方程为：
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int[] count = countZerosOnes(str);

            for (int zero = m; zero >= count[0]; zero--) {
                for (int one = n; one >= count[1]; one--) {
                    // 当前的数 + 前面的数的情况(找前面还没被用的部分） 所以用-- 倒着来，考虑当前数时不应该，把当前数放到之前考虑
                    // 此时的zero和 one满足 ，所以dp[zero - count[0]][one - count[1]] + 1
                    dp[zero][one] = Math.max(dp[zero - count[0]][one - count[1]] + 1, dp[zero][one]);
                }
            }
        }

        return dp[m][n];

    }

    // countZerosOnes 统计该字符串中 0 和 1 的个数
    public int[] countZerosOnes(String s)
    {
        int[] tmp = new int[2];
        for (char c : s.toCharArray()) {
            tmp[c - '0']++;
        }

        return tmp;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
