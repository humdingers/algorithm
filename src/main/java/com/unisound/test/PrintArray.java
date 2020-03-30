package com.unisound.test;

//输入数字n，按顺序打印出从1最大的n位十进制数。
//比如输入3，则打印出1、2、3 一直到最大的3位数即999

public class PrintArray
{
    public static void printNum(int n)
    {
        if (n <= 0) {
            return;
        }

        int[] track = new int[n];

        backpack(track, 0);
    }

    public static void backpack(int[] track, int n)
    {
        if (track.length == n) {
            boolean flag = false;
            for (int j = 0; j < track.length; j++) {
                if (track[j] != 0) {
                    flag = true;
                }

                if (flag) {
                    System.out.print(track[j]);

                }
            }

            if (flag) {
                System.out.println();
            }

        } else {
            for (int i = 0; i <= 9; i++) {
                track[n] = i;
                backpack(track, n + 1);
            }
        }
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
