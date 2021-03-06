package com.unisound.backpack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/*
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
    输入描述:
    输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
//O(N!)
//全排列

/*
 * 面试题 08.08. 有重复字符串的排列组合
有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。

示例1:

 输入：S = "qqe"
 输出：["eqq","qeq","qqe"]
示例2:

 输入：S = "ab"
 输出：["ab", "ba"]
 */
public class PermuteStr
{

    private static void myPrint(String str)
    {
        if (str == null)
            return;
        char[] chs = str.toCharArray();
        myPrint(chs, 0);
    }

    private static void myPrint(char[] str, int i)
    {
        if (i >= str.length)
            return;
        if (i == str.length - 1) {
            System.out.println(String.valueOf(str));
        } else {
            for (int j = i; j < str.length; j++) {
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;

                myPrint(str, i + 1);

                temp = str[j];
                str[j] = str[i];
                str[i] = temp;
            }
        }
    }

    public static void main(String[] args)
    {
        myPrint("aa");

    }

    public ArrayList<String> Permutation(String str)
    {
        ArrayList<String> result = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return result;
        }

        char[] chars = str.toCharArray();
        TreeSet<String> temp = new TreeSet<String>(); // 使用treeset对于排列的重复结果，可以去重，
        // 这里只针对字符串方便去重，但是涉及到路径为列表时不方便使用set去重
        Permutation(chars, 0, temp);
        result.addAll(temp);
        return result;
    }

    public void Permutation(char[] chars, int begin, TreeSet<String> result)
    {
        if (chars == null || chars.length == 0 || begin < 0 || begin > chars.length - 1) {
            return;
        }

        if (begin == chars.length - 1) {
            result.add(String.valueOf(chars));
        } else {
            for (int i = begin; i <= chars.length - 1; i++) {
                swap(chars, begin, i); // 固定begin位置不变，增加后面的位置索引与之交换，每个位置都被固定一次，都与后面位置交换

                Permutation(chars, begin + 1, result);

                swap(chars, begin, i);
            }
        }
    }

    public void swap(char[] x, int a, int b)
    {
        char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public String[] permutation(String s)
    {
        List<String> track = new LinkedList<String>();
        backpack(s.toCharArray(), track, 0);

        return track.toArray(new String[track.size()]);

    }

    public void backpack(char[] arr, List<String> track, int start)
    {
        if (start == arr.length - 1) {
            track.add(new String(arr));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                continue;
            }
            set.add(arr[i]);
            swap(arr, i, start);
            backpack(arr, track, start + 1);
            swap(arr, i, start);

        }
    }

}
