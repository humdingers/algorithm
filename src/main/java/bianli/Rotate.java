package bianli;

/*
     * 面试题 01.07. 旋转矩阵
    给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
    
    不占用额外内存空间能否做到？
    
     
    
    示例 1:
    
    给定 matrix = 
    [
      [1,2,3],
      [4,5,6],
      [7,8,9]
    ],
    
    原地旋转输入矩阵，使其变为:
    [
      [7,4,1],
      [8,5,2],
      [9,6,3]
    ]
 */
/*
 * 我们还可以另辟蹊径，用翻转操作代替旋转操作。我们还是以题目中的示例二

 5  1  9 11
 2  4  8 10
13  3  6  7
15 14 12 16
作为例子，先将其通过水平轴翻转得到：

 5  1  9 11                 15 14 12 16
 2  4  8 10                 13  3  6  7
------------   =水平翻转=>   ------------
13  3  6  7                  2  4  8 10
15 14 12 16                  5  1  9 11
再根据主对角线  翻转得到：

15 14 12 16                   15 13  2  5
13  3  6  7   =主对角线翻转=>   14  3  4  1
 2  4  8 10                   12  6  8  9
 5  1  9 11                   16  7 10 11
水平轴翻转
 matrix[n−row−1][col]
→ 
主对角线翻转
 matrix[col][n−row−1]
​   

 */
public class Rotate
{
    public void rotate(int[][] matrix)
    {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;

            }
        }

    }

}
