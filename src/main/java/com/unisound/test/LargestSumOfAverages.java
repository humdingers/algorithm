package com.unisound.test;

//813. 最大平均值和的分组
/*
* 我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。

  注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。
  
  示例:
  输入: 
  A = [9,1,2,3,9]
  K = 3
  输出: 20
  解释: 
  A 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
  我们也可以把 A 分成[9, 1], [2], [3, 9].
  这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
*/

/*
* @param {number[]} A
* @param {number} K
* @return {number}
* 官方解说是翻译的，写的文绉绉的特别费解。给官方答案加点注释吧
* 官方题解思路:
* 1.动态规划，dp[i]表示数组A中从下标i（包括i）开始到 最后一个数为止分成K个连续非空子数组的子数组的平均值的和的最大值（用xxx代指）
* 2.代码没有直接一上来就求i~(N - 1)分为K个非空连续子数组的xxx值，
* 而是先让i本身从0到(N-1)之间变化，求i~(N-1)分为一个非空连续子数组（一个就是自己，就是没有分）的xxx值。
* 然后再求i本身从0到(N-1)之间变化，i~(N-1)分为2个非空连续子数组的xxx值。
* 以此类推，最后求分为3个、4个知道K个非空连续子数组的xxx值。
* 那么i等于是，得到的不就是0~(N-1)分为K个非空连续子数组的值吗。
* 本来是需要用二维数组dp[i][K]的，但是通过上面的说明，
* 我们可以只用一维数组dp[i],因为我们是先求分为1个非空连续子数组,
* 再求分为2个，再求分为3个，最后求分为K个非空连续子数组。i固定时，i~（N - 1）分为k个
* 非空连续子数组是用i~（N - 1）分为K -1个非空连续子数组的xxx值求出来的，跟k-2、k-3
* 等等等其它一切k的取值无关，所以可以只用一维数组存放dp结果.
*/
public class LargestSumOfAverages
{
    public double largestSumOfAverages(int[] A, int K)
    {
        int len = A.length;
        double[] sum = new double[len + 1];

        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + A[i];
        }

        double[] dp = new double[len + 1];

        for (int i = 0; i < len; i++) {
            dp[i] = (sum[len] - sum[i]) / (len - i);
        }

        // j在后
        for (int k = 1; k < K; k++) {
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    dp[i] = Math.max(dp[i], (sum[j] - sum[i]) / (j - i) + dp[j]);

                }
            }
        }

        return dp[0];
    }

}
