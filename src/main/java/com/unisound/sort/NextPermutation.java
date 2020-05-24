package com.unisound.sort;

/*
 * 31. 下一个排列
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class NextPermutation
{
    public void nextPermutation(int[] nums)
    {
        if (nums == null || nums.length == 0) {
            return;
        }

        int i = 0;
        int j = nums.length - 1;
        boolean flag = false;

        while (j > 0) {
            if (nums[j - 1] < nums[j]) {
                i = j - 1;
                flag = true;
                break;
            } else {
                j--;
            }
        }

        if (flag) {
            int k = nums.length - 1;
            while (k > 0) {
                if (nums[k] > nums[i]) {
                    swap(nums, k, i);
                    transverse(nums, j, nums.length - 1);
                } else {
                    k--;
                }
            }

        } else {
            transverse(nums, j, nums.length - 1);

        }

    }

    public void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void transverse(int[] nums, int i, int j)
    {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

}
