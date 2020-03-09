package com.unisound.doublePointer;

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

//时间复杂度： O(N)，其中 N 是输入矩阵所有元素的个数。因为我们将矩阵中的每个元素都添加进答案里。
public class SpiralOrder
{
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> ans = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        int r1 = 0;
        int r2 = matrix.length - 1;

        int c1 = 0;
        int c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                ans.add(matrix[r1][c]);
            }

            for (int r = r1 + 1; r <= r2; r++) {
                ans.add(matrix[r][c2]);

            }

            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    ans.add(matrix[r2][c]);
                }

                for (int r = r2; r > r1; r--) {
                    ans.add(matrix[r][c1]);

                }

            }
            r1++;
            r2--;
            c1++;

            c2--;

        }

        return ans;
    }

}
