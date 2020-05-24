package com.unisound.binarySearch;

/*
 * 540. 有序数组中的单一元素
    给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
    
    示例 1:
    
    输入: [1,1,2,3,3,4,4,8,8]
    输出: 2
    示例 2:
    
    输入: [3,3,7,7,10,11,11]
    输出: 10
 */
//时间复杂度：O(logn)

/*
 * 1：中间元素的同一元素在右边，且被 mid 分成两半的数组为偶数。

我们将右子数组的第一个元素移除后，则右子数组元素个数变成奇数，我们应将 lo 设置为 mid + 2。



例子 2：中间元素的同一元素在右边，且被 mid 分成两半的数组为奇数。

我们将右子数组的第一个元素移除后，则右子数组的元素个数变为偶数，我们应将 hi 设置为 mid - 1。



例子 3：中间元素的同一元素在左边，且被 mid 分成两半的数组为偶数。

我们将左子数组的最后一个元素移除后，则左子数组的元素个数变为奇数，我们应将 hi 设置为 mid - 2。



例子 4：中间元素的同一元素在左边，且被 mid 分成两半的数组为奇数。

我们将左子数组的最后一个元素移除后，则左子数组的元素个数变为偶数，我们应将 lo 设置为 mid + 1。

 */
public class SingleNonDuplicate
{
    public int singleNonDuplicate(int[] nums)
    {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            boolean ismidEven = (high - mid) % 2 == 0;

            if (nums[mid + 1] == nums[mid]) {
                if (ismidEven) {
                    low = mid + 2;
                }

                else {
                    high = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (ismidEven) {
                    high = mid - 2;
                }

                else {
                    low = mid + 1;
                }

            } else {
                return nums[mid];
            }

        }

        return nums[low];

    }

}
