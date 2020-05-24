package com.unisound.recurse;

public class LastRemaining
{
    // 0~n-1这n个数字排列成一个圆圈，从数字0开始每次从这个圆圈中删除第m个数字。求出这个圆圈里剩下的最后一个数字。
    public static int lastRemainingReverse(int n, int m)
    {
        if (n < 1 || m < 1) {
            return -1;
        }

        if (n == 1) {
            return 0;
        }

        return (lastRemainingReverse(n - 1, m) + m) % n;

    }

    public static int lastRemaining(int n, int m)
    {
        if (n < 1 || m < 1) {
            return -1;
        }

        int lastValue = 0;

        for (int i = 2; i <= n; i++) {
            lastValue = (lastValue + m) % i;
        }

        return lastValue;

    }

    public static void main(String[] args)
    {
        System.out.println(lastRemainingReverse(10, 3));
        System.out.println(lastRemaining(10, 3));

    }

}
