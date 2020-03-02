package com.unisound.test;

//回文子串

/*
* 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

  具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
  
  示例 1:
  
  输入: "abc"
  输出: 3
  解释: 三个回文子串: "a", "b", "c".
*/
public class CountSubstrings
{
    public int countSubstrings(String s)
    {
        int n = s.length();

        int res = 0;

        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                res++;
                left--;
                right++;
            }
        }

        return res;
    }

}
