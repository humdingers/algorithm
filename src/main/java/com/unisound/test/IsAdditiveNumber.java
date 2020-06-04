package com.unisound.test;

/*
 * 306. 累加数
    累加数是一个字符串，组成它的数字可以形成累加序列。
    
    一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
    
    给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
    
    说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
    
    示例 1:
    
    输入: "112358"
    输出: true 
    解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
    示例 2:
    
    输入: "199100199"
    输出: true 
    解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 */
public class IsAdditiveNumber
{
    public boolean isAdditiveNumber(String num)
    {
        int len = num.length();

        return backpack(num, len, 0, 0, 0, 0);

    }

    public boolean backpack(String num, int len, long sum, long pre, int start, int k)
    {
        if (start == len) {
            if (k > 2) {
                return true;
            }
        }

        for (int i = start; i < len; i++) {
            long cur = fetchValue(num, start, i);

            if (cur < 0) {
                continue;
            }

            if (k >= 2 && cur != sum) {
                continue;
            }

            if (backpack(num, len, pre + cur, cur, i + 1, k + 1)) {
                return true;
            }

        }

        return false;

    }

    public long fetchValue(String num, int i, int j)
    {
        if (i < j && num.charAt(i) == '0') {
            return -1;
        }

        long res = 0;
        while (i <= j) {
            res = res * 10 + num.charAt(i) - '0';
            i++;
        }

        return res;
    }

}
