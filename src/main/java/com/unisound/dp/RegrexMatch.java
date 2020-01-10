package com.unisound.dp;

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

            // 通过保留 pattern 中的「*」，同时向后推移 text，来实现「*」将字符重复匹配多次的功能。i,j代表text和pattern的索引

            // 判断第一个字符是否相等，或者pattern对应“.”
            boolean firstMatch =
                (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

            //
            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                // 如果发现有字符和 '*' 结合，
                // 或者匹配该字符 0 次，然后跳过该字符和 '*'
                // 或者当 pattern[0] 和 text[0] 匹配后，移动 text

                ans = (dp(i, j + 2, text, pattern) || firstMatch && dp(i + 1, j, text, pattern));

            } else {
                // 如果没有发现，text和pattern继续移动
                ans = firstMatch && dp(i + 1, j + 1, text, pattern);
            }
        }

        memo[i][j] = ans;

        return ans;

    }

}
