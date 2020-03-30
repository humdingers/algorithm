package com.unisound.test;

// 生成螺旋矩阵
/*
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

    示例:
    
    输入: 3
    输出:
    [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
    ]

 */

//O(n^2)
public class GenerateMatrix
{
    public int[][] generateMatrix(int n)
    {
        int c1 = 0;
        int c2 = n - 1;
        int r1 = 0;
        int r2 = n - 1;

        int num = 1;
        int tar = n * n;
        int[][] res = new int[n][n];

        while (num <= tar) {
            for (int i = c1; i <= c2; i++) {
                res[r1][i] = num++;
            }

            r1++;

            for (int i = r1; i <= r2; i++) {
                res[i][c2] = num++;
            }
            c2--;

            for (int i = c2; i >= c1; i--) {
                res[r2][i] = num++;
            }
            r2--;

            for (int i = r2; i >= r1; i--) {
                res[i][c1] = num++;
            }
            c1++;

        }

        return res;

    }

}
