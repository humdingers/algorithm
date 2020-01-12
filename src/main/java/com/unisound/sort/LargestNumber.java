package com.unisound.sort;

import java.util.Arrays;
import java.util.Comparator;

//最大数
/*
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

    示例 1:
    
    输入: [10,2]
    输出: 210
 */
public class LargestNumber
{

    private class LargerNumberComparator implements Comparator<String>
    {
        public int compare(String a, String b)
        {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums)
    {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }

}
