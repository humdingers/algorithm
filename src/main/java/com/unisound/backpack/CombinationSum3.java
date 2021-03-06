package com.unisound.backpack;

import java.util.ArrayList;
import java.util.List;

// 组合总和3
/*
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
    
    说明：
    
    所有数字都是正整数。
    解集不能包含重复的组合。 
    示例 1:
    
    输入: k = 3, n = 7
    输出: [[1,2,4]]

 */
public class CombinationSum3
{
    public List<List<Integer>> combinationSum3(int k, int n)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> track = new ArrayList<Integer>();

        backpack(1, k, n, track, res);

        return res;
    }

    public void backpack(int start, int k, int n, List<Integer> track, List<List<Integer>> res)
    {
        if (track.size() == k && n == 0) {
            res.add(new ArrayList<Integer>(track));
        } else if (track.size() == k || n == 0) {
            return;
        } else {
            for (int i = start; i <= 9; i++) {
                if (n - i >= 0) {
                    track.add(i);
                    backpack(i + 1, k, n - i, track, res);
                    track.remove(track.size() - 1);

                }
            }
        }
    }

}
