package com.unisound.backpack;

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

 */
public class CombinationSum2
{

    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target < 0) {
            return res;
        }

        // 存在重复元素
        Arrays.sort(candidates);
        List<Integer> track = new ArrayList<Integer>();
        process(0, candidates, target, track, res);
        return res;
    }

    private void process(int start, int[] candidates, int target, List<Integer> track, List<List<Integer>> res)
    {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(track));
        } else {
            for (int i = start; i < candidates.length; i++) {
                // 因为这个数和上个数相同，所以从这个数开始的所以情况，在上个数里面都考虑过了，需要跳过
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                track.add(candidates[i]);
                process(i + 1, candidates, target - candidates[i], track, res);
                track.remove(track.size() - 1);
            }
        }

    }

}
