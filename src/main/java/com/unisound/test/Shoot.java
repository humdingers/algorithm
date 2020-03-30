package com.unisound.test;

//打靶问题 m枪n环, 有多少种情况
public class Shoot
{
    public static int shoot(int M, int N)
    {
        if (M < 1 || N < 0 || N > M * 10) {
            return 0;
        }

        if (M == 1 || N == 0) {
            return 1;
        }

        int sum = 0;
        for (int i = 0; i <= 10; i++) {
            sum += shoot(M - 1, N - i);
        }

        return sum;

    }

}
