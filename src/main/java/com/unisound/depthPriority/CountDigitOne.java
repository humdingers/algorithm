package com.unisound.depthPriority;

// 1～n整数中1出现的次数
/*
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。

例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

 

示例 1：

输入：n = 12
输出：5
示例 2：

输入：n = 13
输出：6

 */
/*
 * f(n))函数的意思是1～n这n个整数的十进制表示中1出现的次数，将n拆分为两部分，最高一位的数字high和其他位的数字last，分别判断情况后将结果相加，看例子更加简单。

    例子如n=1234，high=1, pow=1000, last=234
    
    可以将数字范围分成两部分1~999和1000~1234
    
    1~999这个范围1的个数是f(pow-1)
    1000~1234这个范围1的个数需要分为两部分：
    千分位是1的个数：千分位为1的个数刚好就是234+1(last+1)，注意，这儿只看千分位，不看其他位
    其他位是1的个数：即是234中出现1的个数，为f(last)
    所以全部加起来是f(pow-1) + last + 1 + f(last);
    
    例子如3234，high=3, pow=1000, last=234
    
    可以将数字范围分成两部分1~999，1000~1999，2000~2999和3000~3234
    
    1~999这个范围1的个数是f(pow-1)
    1000~1999这个范围1的个数需要分为两部分：
    千分位是1的个数：千分位为1的个数刚好就是pow，注意，这儿只看千分位，不看其他位
    其他位是1的个数：即是999中出现1的个数，为f(pow-1)
    2000~2999这个范围1的个数是f(pow-1)
    3000~3234这个范围1的个数是f(last)
    所以全部加起来是pow + high*f(pow-1) + f(last);

 */
public class CountDigitOne
{
    private int dfs(int n)
    {
        if (n <= 0) {
            return 0;
        }

        String numStr = String.valueOf(n);
        int high = numStr.charAt(0) - '0';
        int pow = (int) Math.pow(10, numStr.length() - 1);
        int last = n - high * pow;

        if (high == 1) {
            // 最高位是1，如1234, 此时pow = 1000,那么结果由以下三部分构成：
            // (1) dfs(pow - 1)代表[0,999]中1的个数;
            // (2) dfs(last)代表234中1出现的个数;
            // (3) last+1代表固定高位1有多少种情况。
            return dfs(pow - 1) + dfs(last) + last + 1;
        } else {
            // 最高位不为1，如2234，那么结果也分成以下三部分构成：
            // (1) pow代表固定高位1，有多少种情况;
            // (2) high * dfs(pow - 1)代表999以内和1999以内低三位1出现的个数;
            // (3) dfs(last)同上。
            return pow + high * dfs(pow - 1) + dfs(last);
        }
    }

    // 递归求解
    public int countDigitOne(int n)
    {
        return dfs(n);
    }

}
