package com.unisound.algorithm.doublePointer;

//最长回文子串
public class LongestPalindrome
{

    public String longestPalindrome(String s)
    {
        if (s == "" || s.length() < 1)
            return "";

        int start = 0;
        int end = 0;
        // 依次以每个字符为中心寻找
        for (int i = 0; i < s.length(); i++) {

            int mid_1_len = expandAroundCenter(i, i, s); // 奇数

            int mid_2_len = expandAroundCenter(i, i + 1, s); // 偶数

            // 比较两种中心找到的长度最大值
            int max_len = Math.max(mid_1_len, mid_2_len);

            if (max_len > end - start) {
                start = i - (max_len - 1) / 2; // max_len - 1的原因是偶数时是从i开始走的，i+1, 不减去1 start会有错
                end = i + (max_len) / 2;
            }

        }

        return s.substring(start, end + 1);

    }

    public int expandAroundCenter(int left, int right, String s)
    {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1; // left 和right 指针都多走了一步 。但是计算长度时需要加1，所以这里没有减2
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
