package com.unisound.algorithm;

import java.util.Scanner;

public class InputOutput
{

    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);

        int N, M;

        while (cin.hasNext()) {
            N = cin.nextInt();
            M = cin.nextInt();
            System.out.println(String.format("%d %d", N, M));

            for (int i = 0; i < M; i++) {
                int a = cin.nextInt();
                int b = cin.nextInt();
                int c = cin.nextInt();
                System.out.println(String.format("%d %d %d", a, b, c));
            }

        }

    }

}
