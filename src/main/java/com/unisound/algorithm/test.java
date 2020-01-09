package com.unisound.algorithm;

import java.util.Arrays;

public class test
{

    public static void main(String[] args)
    {
        String bigNumberB = "426709752318";
        int maxLength = bigNumberB.length();
        int[] arrayB = new int[maxLength + 1];
        for (int i = 0; i < bigNumberB.length(); i++) {
            arrayB[i] = bigNumberB.charAt(bigNumberB.length() - 1 - i) - '0';
        }
        System.out.print(Arrays.toString(arrayB));
    }
}
