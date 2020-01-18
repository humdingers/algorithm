package com.unisound.slide.window;

//最大连续1的个数 
/*
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。

    返回仅包含 1 的最长（连续）子数组的长度。
    
     
    
    示例 1：
    
    输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
    输出：6
    解释： 
    [1,1,1,0,0,1,1,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 6。

 */
public class LongestOnes
{
    public static int longestOnes(int[] A, int K)
    {
        int left = 0;
        int res = 0;
        int right = 0;

        while (right < A.length) {
            if (A[right] == 0) {
                K--;
            }
            right++;

            while (K < 0) { // 0的个数超过k, 即k<0时，需要移动left来剔除一个0
                if (A[left] == 0) {
                    K++;
                }

                left++; // 左指针等于0的时候，要加一剔除0，保证新加一个0和原先的0正好k个

            }
            res = Math.max(res, right - left); // 此时需要剔除一个0，当等于1的时候，前面已经记录

        }

        return res;

    }

    public static void main(String[] args)
    {
        int[] A = new int[] {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        longestOnes(A, 3);

    }

}
