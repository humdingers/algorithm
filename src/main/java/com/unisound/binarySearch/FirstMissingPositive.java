package com.unisound.binarySearch;

/*
 * 41. 缺失的第一个正数
给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

 

示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1
 */

/*
 *“只能使用常数级别的空间”，由于是正数，而要找的数一定在 [1, N + 1] 左闭右闭（这里 N 是数组的长度）这个区间里。
 *因此，我们可以就把原始的数组当做哈希表来使用。事实上，哈希表其实本身也是一个数组；
我们要找的数就在 [1, N + 1] 里，最后 N + 1 这个元素我们不用找。因为在前面的 N 个元素都找不到的情况下，我们才返回 N + 1；
那么，我们可以采取这样的思路：就把 1 这个数放到下标为 0 的位置，
 2 这个数放到下标为 1 的位置，按照这种思路整理一遍数组。然后我们再遍历一次数组，
 第 1 个遇到的它的值不等于下标的那个数，就是我们要找的缺失的第一个正数(i+1)。

 */
//时间O(N) 空间O(1)
public class FirstMissingPositive
{
    public int firstMissingPositive(int[] nums)
    {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            // 可能被换过来的数，也是在正确的索引位置，因此可以继续换
            while (nums[i] > 0 && nums[i] < len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);

            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != (i + 1)) {
                return i + 1;
            }
        }

        return len + 1;

    }

    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
