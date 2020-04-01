package com.unisound.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//组合总和
/*
* 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

  candidates 中的每个数字在每个组合中只能使用一次。
  
  说明：
  
  所有数字（包括目标数）都是正整数。
  解集不能包含重复的组合。 
  示例 1:
  
  输入: candidates = [10,1,2,7,6,1,5], target = 8,
  所求解集为:
  [
    [1, 7],
    [1, 2, 5],
    [2, 6],
    [1, 1, 6]
  ]
 O(2^n)
*/
public class CombinationSum2
{

    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        List<Integer> track = new ArrayList<Integer>();

        backpack(candidates, target, track, 0, res);

        return res;

    }

    public void backpack(int[] candidates, int target, List<Integer> track, int start, List<List<Integer>> res)
    {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<Integer>(track));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                track.add(candidates[i]);
                backpack(candidates, target - candidates[i], track, i + 1, res);
                track.remove(track.size() - 1);
            }
        }

    }

}
