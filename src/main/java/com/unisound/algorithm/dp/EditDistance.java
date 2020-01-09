package com.unisound.algorithm.dp;

//编辑距离
/*
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

    你可以对一个单词进行如下三种操作：
    
    插入一个字符
    删除一个字符
    替换一个字符
    示例 1:
    
    输入: word1 = "horse", word2 = "ros"
    输出: 3
    解释: 
    horse -> rorse (将 'h' 替换为 'r')
    rorse -> rose (删除 'r')
    rose -> ros (删除 'e')

 */
public class EditDistance
{
    static Integer[][] memo;

    public static int minDistance(String word1, String word2)
    {
        memo = new Integer[word1.length()][word2.length()];

        return dp(word1.length() - 1, word2.length() - 1, word1, word2);

    }

    public static int dp(int i, int j, String word1, String word2)
    {
        if (i == -1) {
            return j + 1;
        }

        if (j == -1) {
            return i + 1;

        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dp(i - 1, j - 1, word1, word2);
        }

        else {
            memo[i][j] =
                min(dp(i, j - 1, word1, word2) + 1, dp(i - 1, j, word1, word2) + 1, dp(i - 1, j - 1, word1, word2) + 1);
        }

        return memo[i][j];

    }

    private static int min(int a, int b, int c)
    {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args)
    {
        System.out.print(minDistance("horse", "ros"));

    }

}
