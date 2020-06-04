package com.unisound.doublePointer;

/*
 * 84. 柱状图中最大的矩形
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。

以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。


图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。


示例:

输入: [2,1,5,6,2,3]
输出: 10
 */
import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 时间复杂度：O(N)，输入数组里的每一个元素入栈一次，出栈一次。
空间复杂度：O(N)，栈的空间最多为 N
 */
public class LargestRectangleArea
{
    public int largestRectangleArea(int[] heights)
    {
        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
        // 这两个站在两边的柱形有一个很形象的名词，叫做哨兵（Sentinel）。

        // 有了这两个柱形：

        // 左边的柱形（第 1 个柱形）由于它一定比输入数组里任何一个元素小，它肯定不会出栈，因此栈一定不会为空；

        // 右边的柱形（第 2 个柱形）也正是因为它一定比输入数组里任何一个元素小，它会让所有输入数组里的元素出栈（第 1 个哨兵元素除外）。

        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);

        Deque<Integer> stack = new ArrayDeque<>();

        int area = 0;

        for (int i = 0; i < tmp.length; i++) {

            // 单调递增的单调栈
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积🌶️ ～
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                area = Math.max(area, (i - stack.peek() - 1) * h);

            }

            stack.push(i);
        }

        return area;

    }

}
