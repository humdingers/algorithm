package com.unisound.test;

//打靶问题 m枪n环, 有多少种情况
public class Shoot
{
    public static int shoot(int M, int N)
    {
        if (N < 0 || N > 10 * M) {
            return 0;
        }

        if (M == 1) {
            return 1;
        }

        if (M == 0) {
            return 0;
        }

        if (N == 0) {
            return 1;
        }

        int sum = 0;

        for (int i = 0; i <= 10; i++) {
            sum += shoot(M - 1, N - i);
        }

        return sum;

    }

}
