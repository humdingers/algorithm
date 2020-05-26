package com.unisound.backpack;

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
public class permutateUniqueStr
{
    public String[] permutation(String S)
    {
        List<String> track = new ArrayList<>();
        permutate(S.toCharArray(), track, 0);
        String[] res = new String[track.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = track.get(i);
        }
        return res;
    }

    public void permutate(char[] arr, List<String> track, int first)
    {
        if (first == arr.length - 1) {
            track.add(new String(arr));
            return;
        }
        for (int i = first; i < arr.length; i++) {
            swap(arr, first, i);
            permutate(arr, track, first + 1);
            swap(arr, first, i);
        }
    }

    public void swap(char[] arr, int i, int j)
    {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
