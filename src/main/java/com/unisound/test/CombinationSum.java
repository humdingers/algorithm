package com.unisound.test;

import java.util.ArrayList;
import java.util.List;

//组合总和
/*
* 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

  candidates 中的数字可以无限制重复被选取。
  
  说明：
  
  所有数字（包括 target）都是正整数。
  解集不能包含重复的组合。 
  示例 1:
  
  输入: candidates = [2,3,6,7], target = 7,
  所求解集为:
  [
    [7],
    [2,2,3]
  ]
*/
public class CombinationSum
{

    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

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

                track.add(candidates[i]);
                backpack(candidates, target - candidates[i], track, i, res);
                track.remove(track.size() - 1);
            }
        }

    }

}
