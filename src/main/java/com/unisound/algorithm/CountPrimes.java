package com.unisound.algorithm;

import java.util.Arrays;

public class CountPrimes
{
    public int countPrimes(int n)
    {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // 素数的倍数不是素数
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        // 0,1不是素数
        for (int i = 2; i < n; i++) {
            if (isPrime[i])
                count += 1;
        }

        return count;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
