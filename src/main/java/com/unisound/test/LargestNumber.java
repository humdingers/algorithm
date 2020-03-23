package com.unisound.test;

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

    private class largestNumberCompare implements Comparator<String>
    {
        public int compare(String a, String b)
        {
            String o1 = a + b;

            String o2 = b + a;

            return o2.compareTo(o1);
        }

    }

    public String largestNumber(int[] nums)
    {
        String[] tmp = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            tmp[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(tmp, new largestNumberCompare());

        if (tmp[0].equals("0")) {
            return "0";
        }

        String largestnumber = new String();
        for (String numStr : tmp) {
            largestnumber += numStr;
        }

        return largestnumber;

    }

}
