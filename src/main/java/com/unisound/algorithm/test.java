package com.unisound.algorithm;

import java.util.Arrays;

public class test
{

    public static int add(int[][] dirs)
    {
        return ++dirs[0][0];
    }

    public static void main(String[] args)
    {
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        String bigNumberB = "426709752318";
        int maxLength = bigNumberB.length();
        int[] arrayB = new int[maxLength + 1];
        for (int i = 0; i < bigNumberB.length(); i++) {
            arrayB[i] = bigNumberB.charAt(bigNumberB.length() - 1 - i) - '0';
        }
        System.out.print(Arrays.toString(arrayB));
        System.out.print(add(dirs));

    }
}
