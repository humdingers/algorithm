package com.unisound.test;

import java.util.ArrayList;
import java.util.List;

//螺旋矩阵
//顺序打印矩阵
/*
* 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

  示例 1:
  
  输入:
  [
   [ 1, 2, 3 ],
   [ 4, 5, 6 ],
   [ 7, 8, 9 ]
  ]
  输出: [1,2,3,6,9,8,7,4,5]

*/
public class SpiralOrder
{
    public List<Integer> spiralOrder(int[][] matrix)
    {

        List<Integer> res = new ArrayList<Integer>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int c1 = 0;
        int c2 = matrix[0].length - 1;

        int r1 = 0;
        int r2 = matrix.length - 1;

        while (c1 <= c2 && r1 <= r2) {
            for (int c = c1; c <= c2; c++) {
                res.add(matrix[r1][c]);

            }

            for (int r = r1 + 1; r <= r2; r++) {
                res.add(matrix[r][c2]);

            }
            if (c1 < c2 && r1 < r2) {
                for (int c = c2 - 1; c > c1; c--) {
                    res.add(matrix[r2][c]);

                }

                for (int r = r2; r > r1; r--) {
                    res.add(matrix[r][c1]);

                }

            }

            r1++;
            r2--;
            c1++;
            c2--;

        }

        return res;

    }

}
