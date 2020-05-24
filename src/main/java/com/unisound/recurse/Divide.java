package com.unisound.recurse;

/*
 * 29. 两数相除
    给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
    
    返回被除数 dividend 除以除数 divisor 得到的商。
    
    整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
    
     
    
    示例 1:
    
    输入: dividend = 10, divisor = 3
    输出: 3
    解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 */
public class Divide
{
    public int divide(int dividend, int divisor)
    {

        if (dividend == 0)
            return 0;
        if (divisor == 1)
            return dividend;

        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }

        int sign = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1 : -1;

        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;

        if (a > b)
            return 0;

        int ans = div(a, b);

        return sign == -1 ? -ans : ans;

    }

    public int div(int a, int b)
    {
        if (a > b)
            return 0;

        int count = 1;
        int b_copy = b;

        while (b_copy + b_copy >= a && b_copy + b_copy < 0) {
            b_copy += b_copy;
            count += count;
        }

        return count + div(a - b_copy, b);

    }

}
