package com.unisound.test;

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
        int right = 0;

        int res = 0;

        while (right < A.length) {
            if (A[right] == 0) {
                K--;
            }

            right++;

            while (K < 0) {
                if (A[left] == 0) {
                    K++;
                }

                left++;
            }

            res = Math.max(res, right - left);

        }

        return res;
    }

}
