package com.unisound.algorithm;

/*
 * 397. 整数替换
给定一个正整数 n，你可以做如下操作：

    1. 如果 n 是偶数，则用 n / 2替换 n。
    2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
    n 变为 1 所需的最小替换次数是多少？
    
    示例 1:
    
    输入:
    8
    
    输出:
    3
    
    解释:
    8 -> 4 -> 2 -> 1
 */
public class IntegerReplacement
{
    public int integerReplacement(int n)
    {
        int count = 0;
        while (n != 1) {
            // 与运算判断最后一位来区分奇偶
            if ((n & 1) == 0) {
                // 偶数直接无符号右移，
                // 2147483647 会被奇数处理算法加一溢出为负数，
                // 若选用带符号右移将无法回到1.
                n >>>= 1;
                count++;
            } else {
                // 识别奇数的上一位是否为1，即 以 10 结尾(xxxx01)还是以11结尾(xxxx11)
                if ((n & 2) == 0) {
                    // 01结尾最优则应当 用 n -1 取代 n
                    n -= 1;
                    count++;
                } else {
                    // 11结尾除3这个特殊情况外，其余选用 n + 1取代 n，原因如上
                    if (n == 3) {
                        // 3的特殊性处理，原因如上
                        count += 2;
                        break;
                    } else {
                        n += 1;
                    }
                    count++;
                }
            }
        }
        return count;
    }

}
