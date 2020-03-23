package com.unisound.doublePointer;

/*
 * 给定两个数组，编写一个函数来计算它们的交集。

    示例 1:
    
    输入: nums1 = [1,2,2,1], nums2 = [2,2]
    输出: [2,2]
    示例 2:
    
    输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出: [4,9]
    
    O(nlogn+mlogm)

 */
import java.util.Arrays;

public class Intersection1
{
    public int[] intersect(int[] nums1, int[] nums2)
    {
        int i = 0, j = 0, k = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums1[k++] = nums1[i];
                ++i;
                ++j;
            }

            else if (nums1[i] < nums2[j]) {
                ++i;
            }

            else {
                ++j;
            }

        }

        return Arrays.copyOfRange(nums1, 0, k);

    }

}
