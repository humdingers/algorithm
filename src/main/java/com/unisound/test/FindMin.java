package com.unisound.test;

//寻找旋转排序数组最小值
/*
* 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

  ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
  
  请找出其中最小的元素。
  
  你可以假设数组中不存在重复元素。
  
  示例 1:
  
  输入: [3,4,5,1,2]
  输出: 1

*/

/*
* 寻找这个变化点的特点：

  所有变化点左侧元素 > 数组第一个元素
  
  所有变化点右侧元素 < 数组第一个元素
*/

//O(logN) 
public class FindMin
{
    public int findMin(int[] nums)
    {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        if (nums[right] > nums[left]) {
            return nums[0];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;

    }

}
