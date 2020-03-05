package com.unisound.binarySearch;

//有序矩阵中第K小的元素
/*
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
请注意，它是排序后的第k小元素，而不是第k个元素。

示例:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

返回 13。
 */
public class FindKthNum
{
    // 方法1，二分套二分，时间复杂度O(n*logn*logn)
    public static int findKthNum(int[][] matrix, int k)
    {
        int row = matrix.length;
        int col = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[row - 1][col - 1];

        int count = 0;
        while (low <= high) {
            count = 0;
            int mid = low + (high - low) / 2;
            for (int[] item : matrix) {
                count += binarySearchCount(item, mid);
            }

            if (count < k) {
                low = mid + 1;

            } else { // 此时必须为等于， 此时mid
                high = mid - 1;
            }
        }

        return low;

    }

    public static int binarySearchCount(int[] data, int midValue)
    {
        int begin = 0;
        int end = data.length - 1;

        while (begin <= end) {
            int mid = begin + (end - begin) / 2;

            if (data[mid] <= midValue) {
                begin = mid + 1; // 统计个数 +1 使得 begin>end 跳出循环
            } else {
                end = mid - 1;
            }
        }

        // 全大于、全小于k都是begin，正好对应上了
        // 这里返回的begin表示<=k的数的个数
        return begin;

    }

}
