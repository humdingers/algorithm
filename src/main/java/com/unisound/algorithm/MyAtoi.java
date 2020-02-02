package com.unisound.algorithm;

//字符串转整数
/*
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。

    首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
    
    当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
    
    该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
    
    注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
    
    在任何情况下，若函数不能进行有效的转换时，请返回 0。
    
    说明：
    
    假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
    
    示例 1:
    
    输入: "42"
    输出: 42
    示例 2:
    
    输入: "   -42"
    输出: -42
    解释: 第一个非空白字符为 '-', 它是一个负号。
         我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。

 */

/*
 * 看到字符串那就先转换为char[]。
    这道题,就从左往右开始遍历。寻找数据的起始值。情况如下。
    1.遇到空格则跳过。
    2. 非空格情况
    2.1
    符号'-'或者'+'则记录为正还是负任然后开始处理数据转换，将当前index++之后开始处理数据。
    2.2
    符号不是数字则返回0.是数字则开始记录当前index，开始处理数字。
    寻找到起始值之后开始向右遍历转换数字。
    数字获取可以通过
    char转换为int 可以用 '1' - 48 = 1 来实现。并将计算值乘上1 或者 -1。
    pop = (charList[i] -48) * zf; 其中zf为之前根据'+'或者'-'。默认为1，
    叠加结果为。
    rev = rev * 10 + pop;
    但是执行这一步之前需要判断，rev是否移除才能进行相加。情况。
    1.叠加上去的结果不能大于Integer.MAX_VALUE，否则返回Integer.MAX_VALUE
    2.且不能小于Integer.MIN_VALUE，否则返回Integer.MIN_VALUE
    则进行处理。
    若大于。
    if(rev>Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)){
    return Integer.MAX_VALUE;
    }
    
    if(rev<Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)){
    return Integer.MIN_VALUE;
    }
    循环结束或者遇到非数字情况。则直接return rev;即可。

 */
public class MyAtoi
{
    public int myAtoi(String str)
    {
        int rev = 0;
        char[] charList = str.toCharArray();
        int length = str.length();
        int zf = 1;
        int i = 0;
        int pop = 0;
        for (; i < length; i++) {
            if (charList[i] == ' ') {
                continue;
            } else {
                if (charList[i] == '-') {
                    i++;
                    zf = -1;
                    break;
                }
                if (charList[i] == '+') {
                    i++;
                    break;
                }
                if (charList[i] < '0' || charList[i] > '9') {
                    return 0;
                } else {
                    break;
                }
            }
        }
        if (i == length) {
            return 0;
        }
        for (; i < length; i++) {
            if (charList[i] < '0' || charList[i] > '9') {
                return rev;
            }
            pop = (charList[i] - 48) * zf;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return Integer.MAX_VALUE;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return Integer.MIN_VALUE;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int myAtoi2(String str)
    {
        int index = 0, sign = 1, total = 0;
        // 1. Empty string
        if (str.length() == 0)
            return 0;

        // 2. Remove Spaces
        while (str.charAt(index) == ' ' && index < str.length())
            index++;

        // 3. Handle signs
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // 4. Convert number and avoid overflow
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9)
                break;

            // check if total will be overflow after 10 times and add digit
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }

}
