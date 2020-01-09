package com.unisound.doublePointer;

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
        int res = 0;
        int N = s.length();
        // 在长度为 N 的字符串中，可能的回文串中心位置有 2N-1 个：字母，或两个字母中间。

        // 从每一个回文串中心开始统计回文串数量。回文区间 [a, b] 表示 S[a], S[a+1], ..., S[b] 是回文串，根据回文串定义可知 [a+1, b-1] 也是回文区间。

        for (int center = 0; center < 2 * N - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                res++;
                left--;
                right++;

            }

        }

        return res;

    }

}
