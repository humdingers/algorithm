package com.unisound.doublePointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection
{
    // 两个数组的交集
    /*
     * 给定两个数组，编写一个函数来计算它们的交集。 示例 1: 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2]
     */
    // 或者 其思想是将两个数组转换为集合 set，然后迭代较小的集合检查是否存在在较大集合中。平均情况下，这种方法的时间复杂度为 O(n+m)O(n+m)。
    public int[] intersection(int[] nums1, int[] nums2)
    {
        Set<Integer> res = new HashSet<Integer>();
        int i = 0, j = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;

            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }

        }

        int[] resArray = new int[res.size()];
        int k = 0;
        for (int item : res) {
            resArray[k++] = item;
        }

        return resArray;

    }

}
