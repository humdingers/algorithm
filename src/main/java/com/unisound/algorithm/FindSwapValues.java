package com.unisound.algorithm;

import java.util.HashSet;

//交换和
/*
 * 面试题 16.21. 交换和
    给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
    
    返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
    
    示例:
    
    输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
    输出: [1, 3]
 */
/*
 * 先求两个数组的差值diff = sum(a)-sum(b), 如果为奇数直接return [], 因为交换任何数得到的diff一定是两个数字差值的2倍
然后将数组b作为集合, 遍历数组a, 判断其每个元素-diff//2是否在b集合中, 在的话即为所求
代码

 */
public class FindSwapValues
{
    public int[] findSwapValues(int[] array1, int[] array2)
    {
        int sum1 = 0, sum2 = 0;
        int len1 = array1.length, len2 = array2.length;
        HashSet<Integer> set1 = new HashSet<Integer>(len1), set2 = new HashSet<Integer>(len2);
        for (int num : array1) {
            sum1 += num;
            set1.add(num);
        }
        for (int num : array2) {
            sum2 += num;
            set2.add(num);
        }

        if ((sum1 + sum2) % 2 != 0)
            return new int[0];
        int avg = (sum1 + sum2) >> 1;
        int diff1 = sum1 - avg;

        if (diff1 < 0) {
            for (int num1 : set1)
                if (set2.contains(num1 - diff1))
                    return new int[] {num1, num1 - diff1};
        } else {
            for (int num2 : set2)
                if (set1.contains(num2 + diff1))
                    return new int[] {num2 + diff1, num2};
        }
        return new int[0];
    }

}
