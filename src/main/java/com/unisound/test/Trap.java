package com.unisound.test;

//接雨水

/*
* 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
* 示例:

      输入: [0,1,0,2,1,0,1,3,2,1,2,1]
      输出: 6
*/

public class Trap
{
    public int trap(int[] height)
    {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;

        int left = 0;
        int right = n - 1;
        int ans = 0;

        int leftMax = height[0];
        int rightMax = height[n - 1];

        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            }

            else {
                ans += rightMax - height[right];
                right--;
            }
        }

        return ans;

    }

}
