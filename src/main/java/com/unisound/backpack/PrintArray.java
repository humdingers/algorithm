package com.unisound.backpack;

//输入数字n，按顺序打印出从1最大的n位十进制数。
//比如输入3，则打印出1、2、3 一直到最大的3位数即999

public class PrintArray
{
    public static void printNum(int n)
    {
        if (n <= 0) {
            return;
        }

        int[] track = new int[n]; // 路径列表，存储找到的路径，也就是每个位置存储了每一位的数字

        printArray(track, 0);

    }

    public static void printArray(int[] track, int n)
    {
        // 满足结束条件
        if (n == track.length) {
            boolean flag = false;
            for (int j = 0; j < track.length; j++) {
                // 前几位数字为0 的，过滤0
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
            // 选择列表是[0-9]，对每一位可重复的全排列
            for (int i = 0; i < 10; i++) {
                track[n] = i; // track记录了每一位选择的数字
                printArray(track, n + 1); // 选择当前位的数字，递归进入下一位进行选择

            }
        }

    }

    public static void main(String[] args)
    {
        printNum(4);

    }

}
