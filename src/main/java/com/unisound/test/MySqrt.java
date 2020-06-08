package com.unisound.test;

/*
 * 由于 x 平方根的整数部分ans 是满足 k^2≤x 的最大 k 值，因此我们可以对 k 进行二分查找，从而得到答案。

二分查找的下界为 0，上界可以粗略地设定为 x。在二分查找的每一步中，我们只需要比较中间元素 mid 的平方与 x 的大小关系，
并通过比较的结果调整上下界的范围。由于我们所有的运算都是整数运算，不会存在误差，因此在得到最终的答案 ans 后，也就不需要再去尝试 ans+1 了。

 */

//时间复杂度：O(logx)，即为二分查找需要的次数。

/*
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

说明：不要使用任何内置的库函数，如  sqrt。

示例 1：

输入：16
输出：True
示例 2：

输入：14
输出：False

 */
public class MySqrt
{
    public int mySqrt(int x)
    {
        int left = 0;
        int right = x;

        int res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    // 这个是可能会找到的，不是确定个边界square == num
    public boolean isPerfectSquare(int num)
    {

        if (num < 2) {
            return true;
        }

        long left = 2;
        long right = num / 2;

        long square = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            square = mid * mid;

            if (square == num) {
                return true;
            }

            if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return false;

    }

}
