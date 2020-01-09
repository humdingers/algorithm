package com.unisound.algorithm;

//旋转数组
/*
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

        示例 1:
        
        输入: [1,2,3,4,5,6,7] 和 k = 3
        输出: [5,6,7,1,2,3,4]
        解释:
        向右旋转 1 步: [7,1,2,3,4,5,6]
        向右旋转 2 步: [6,7,1,2,3,4,5]
        向右旋转 3 步: [5,6,7,1,2,3,4]

 */

/*
 * 这个方法基于这个事实：当我们旋转数组 k 次， k\%nk%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
        
        在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-kn−k 个元素，就能得到想要的结果。
        
        假设 n=7n=7 且 k=3k=3 。
        
        原始数组                  : 1 2 3 4 5 6 7
        反转所有数字后             : 7 6 5 4 3 2 1
        反转前 k 个数字后          : 5 6 7 4 3 2 1
        反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果

 */
public class RotateArray
{

    public void rotateArray(int[] nums, int k)
    {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public void reverse(int[] nums, int start, int end)
    {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
