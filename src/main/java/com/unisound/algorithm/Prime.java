package com.unisound.algorithm;

public class Prime
{
    // test if n is prime
    public static boolean isPrime(int n)
    {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return n != 1; // 1 is not prime
    }

    public static void main(String[] args)
    {
        System.out.print(isPrime(2));

    }

}
