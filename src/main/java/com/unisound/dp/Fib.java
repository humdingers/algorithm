package com.unisound.dp;

public class Fib
{
    public int fib(int n)
    {
        if (n < 2)
            return n;
        int prev = 0;
        int cur = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = prev + cur;
            prev = cur;
            cur = sum;
        }
        return cur;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
