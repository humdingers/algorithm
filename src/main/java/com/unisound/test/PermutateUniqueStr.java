package com.unisound.test;

import java.util.ArrayList;
import java.util.List;

/*
 * 面试题 08.07. 无重复字符串的排列组合
    无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
    
    示例1:
    
     输入：S = "qwe"
     输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
    示例2:
    
     输入：S = "ab"
     输出：["ab", "ba"]
 */
public class PermutateUniqueStr
{
    public String[] permutation(String S)
    {
        List<String> track = new ArrayList<String>();
        backpack(S.toCharArray(), track, 0);
        String[] res = new String[track.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = track.get(i);
        }
        return res;

    }

    public void backpack(char[] arr, List<String> track, int start)
    {
        if (start == arr.length - 1) {
            track.add(new String(arr));
        } else {
            for (int i = start; i < arr.length; i++) {
                swap(arr, i, start);
                backpack(arr, track, start + 1);
                swap(arr, i, start);
            }
        }
    }

    public void swap(char[] arr, int i, int j)
    {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
