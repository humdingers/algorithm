package com.unisound.doublePointer;
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

        // 位置 i 能达到的水柱高度和其左边的最高柱子、右边的最高柱子有关，我们分别称这两个柱子高度为l_max和r_max；
        // 位置 i 最大的水柱高度就是min(l_max, r_max)。

        // l_max和r_max代表的是height[0..left]和height[right..end]的最高柱子高度
        // 此时的l_max是left指针左边的最高柱子，但是r_max并不一定是left指针右边最高的柱子，这真的可以得到正确答案吗？

        // 其实这个问题要这么思考，我们只在乎min(l_max, r_max)。对于上图的情况，我们已经知道l_max <
        // r_max了，至于这个r_max是不是右边最大的，不重要，重要的是height[i]能够装的水只和l_max有关。

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
