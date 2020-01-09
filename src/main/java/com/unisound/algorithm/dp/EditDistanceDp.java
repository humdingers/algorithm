package com.unisound.algorithm.dp;

public class EditDistanceDp
{
    public static int minDistance(String word1, String word2)
    {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];

                } else {
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                }

            }
        }

        return dp[m][n];

    }

    private static int min(int a, int b, int c)
    {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
