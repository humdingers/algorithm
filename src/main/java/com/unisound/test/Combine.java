package com.unisound.test;

import java.util.ArrayList;
import java.util.List;

//组合
/*
* 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
[2,4],
[3,4],
[2,3],
[1,2],
[1,3],
[1,4],
]

*/

//O(k CNk 组合)

public class Combine
{
    public List<List<Integer>> combine(int n, int k)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (n < k) {
            return res;
        }

        List<Integer> track = new ArrayList<Integer>();

        backpack(1, n, k, track, res);

        return res;

    }

    public void backpack(int start, int n, int k, List<Integer> track, List<List<Integer>> res)
    {
        if (track.size() == k) {
            res.add(new ArrayList<Integer>(track));
        } else {
            for (int i = start; i <= n; i++) {
                track.add(i);
                backpack(i + 1, n, k, track, res);
                track.remove(track.size() - 1);
            }
        }

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
