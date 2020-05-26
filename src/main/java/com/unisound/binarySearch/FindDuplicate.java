package com.unisound.binarySearch;

/*
 * 287. 寻找重复数
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

示例 1:

输入: [1,3,4,2,2]
输出: 2
示例 2:

输入: [3,1,3,4,2]
输出: 3
 */
/*
 * 二分法的思路是先猜一个数（有效范围 [left, right]里的中间数 mid），然后统计原始数组中小于等于这个中间数的元素的个数 cnt，如果 cnt 严格大于 mid，（注意我加了着重号的部分「小于等于」、「严格大于」）。根据抽屉原理，重复元素就在区间 [left, mid] 里；

与绝大多数二分法问题的不同点是：正着思考是容易的，即：思考哪边区间存在重复数是容易的，因为有抽屉原理做保证。我们通过一个具体的例子来分析应该如何编写代码；

以 [2, 4, 5, 2, 3, 1, 6, 7] 为例，一共 8 个数，n + 1 = 8，n = 7，根据题目意思，每个数都在 1 和 7 之间。

例如：区间 [1, 7] 的中位数是 4，遍历整个数组，统计小于等于 4 的整数的个数，最多为 4 个，等于 4 的时候也可能有重复。但是，如果整个数组里小于等于 4 的整数的个数如果严格大于 4个，就说明重复的数存在于区间 [1, 4]。
 */
public class FindDuplicate
{
    public int findDuplicate(int[] nums)
    {

        int len = nums.length;
        int left = 1;
        int right = len - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if (count > mid) {
                // 重复元素位于区间 [left, mid]
                right = mid;

            } else {
                left = mid + 1;
            }

        }

        return left;

    }

}
