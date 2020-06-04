package com.unisound.test;

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
    public int findKthNum(int[][] matrix, int k)
    {
        int row = matrix.length;
        int cols = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[row - 1][cols - 1];

        int count = 0;
        while (low <= high) {
            int midval = low + (high - low) / 2;

            for (int[] nums : matrix) {
                count += search(nums, midval);

            }

            if (count < k) {
                low = midval + 1;
            } else {
                high = midval - 1;
            }
        }

        return low;
    }

    public int search(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left;
    }

}
