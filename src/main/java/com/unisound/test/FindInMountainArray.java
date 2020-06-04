package com.unisound.test;

/*
 * 山脉数组查找目标值
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。

如果不存在这样的下标 index，就请返回 -1。

 

何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：

首先，A.length >= 3

其次，在 0 < i < A.length - 1 条件下，存在 i 使得：

A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]
 

你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：

MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
MountainArray.length() - 会返回该数组的长度
 

注意：

对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。

为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请注意这 不是一个正确答案。

 

示例 1：

输入：array = [1,2,3,4,5,3,1], target = 3
输出：2
解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。

 */
interface MountainArray
{
    public int get(int index);

    public int length();
}

class MountainArrayImpl implements MountainArray
{
    private int[] arr;

    private int size;

    public MountainArrayImpl(int[] arr)
    {
        this.arr = arr;
        this.size = this.arr.length;
    }

    @Override
    public int get(int index)
    {
        return this.arr[index];
    }

    @Override
    public int length()
    {
        return this.size;
    }

}

class FindInMountainArray
{

    // 特别注意：3 个辅助方法的分支出奇地一样，因此选中位数均选左中位数，才不会发生死循环
    public int findInMountainArray(int target, MountainArray mountainArr)
    {
        int left = 0;
        int right = mountainArr.length() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;

            } else {
                right = mid;
            }

        }

        int peakIndex = left;

        int index = search(target, mountainArr, 0, peakIndex, true);

        return index != -1 ? index : search(target, mountainArr, peakIndex + 1, mountainArr.length() - 1, false);

    }

    public int search(int target, MountainArray mountainArr, int left, int right, boolean asc)
    {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int midval = mountainArr.get(mid);

            if (midval == target) {
                return mid;
            }
            if (midval < target) {
                left = asc ? mid + 1 : left;
                right = asc ? right : mid - 1;
            } else {
                left = asc ? left : mid + 1;
                right = asc ? mid - 1 : right;
            }
        }
        return -1;
    }

}
