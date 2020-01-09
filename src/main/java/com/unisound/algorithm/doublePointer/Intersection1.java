package com.unisound.algorithm.doublePointer;

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
