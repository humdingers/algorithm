package com.unisound.bigNum;

//求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
public class NumSum
{
    public static int sum(int n)
    {
        // 求和公式Sn=n(a1+an)/2
        int sum = (int) (Math.pow(n, 2) + n);
        return sum >> 1; // 右移相当于除以2
    }

    public static int sumRecurse(int n)
    {
        int sum = n;
        // 利用逻辑与的短路特性实现递归终
        if (n > 0) {
            sum += sumRecurse(n - 1);
        }
        // boolean flag = (n > 0) && ((sum += sumRecurse(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args)
    {
        System.out.println(sumRecurse(15));
        System.out.println(sum(15));

    }

}
