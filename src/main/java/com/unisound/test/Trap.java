package com.unisound.test;

//接雨水

/*
* 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
* 示例:

      输入: [0,1,0,2,1,0,1,3,2,1,2,1]
      输出: 6
*/
//复杂度O(n)
public class Trap
{
    public int trap(int[] height)
    {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;

        int leftMax = height[0];
        int rightMax = height[height.length - 1];

        int res = 0;

        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }

        }

        return res;
    }

}
