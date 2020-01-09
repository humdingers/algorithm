package com.unisound.binarySearch;

// 二维数组查找
//搜索二维矩阵
/*
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
    
    每行中的整数从左到右按升序排列。
    每行的第一个整数大于前一行的最后一个整数。
    示例 1:
    
    输入:
    matrix = [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    target = 3
    输出: true
 */
public class SearchMatrix
{
    // 右上角开始查找，
    public boolean searchMatrix(int[][] matrix, int target)
    {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        int i = 0;
        int j = n - 1;

        while (i <= m - 1 && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }

            else if (matrix[i][j] > target) {
                j--;

            } else if (matrix[i][j] < target) {
                i++;

            }

        }

        return false;

    }

    public boolean searchMatrixBinarySearch(int[][] matrix, int target)
    {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;

            }

        }

        return false;

    }

}
