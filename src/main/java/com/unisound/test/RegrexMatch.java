package com.unisound.test;

//正则表达式匹配
/*
* 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。

*/
public class RegrexMatch
{
    Boolean[][] memo;

    public boolean isMatch(String text, String pattern)
    {
        memo = new Boolean[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);

    }

    public boolean dp(int i, int j, String text, String pattern)
    {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean ans;

        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            boolean firstMatch =
                (i < text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                ans = (firstMatch && dp(i + 1, j, text, pattern)) || dp(i, j + 2, text, pattern);
            } else {
                ans = firstMatch && dp(i + 1, j + 1, text, pattern);
            }
        }

        memo[i][j] = ans;

        return ans;

    }

}
