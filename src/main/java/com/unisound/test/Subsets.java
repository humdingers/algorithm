package com.unisound.test;

import java.util.ArrayList;
import java.util.List;

//子集
/*
* 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

  说明：解集不能包含重复的子集。
  
  示例:
  
  输入: nums = [1,2,3]
  输出:
  [
    [3],
    [1],
    [2],
    [1,2,3],
    [1,3],
    [2,3],
    [1,2],
    []
  ]


*/
public class Subsets
{
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        List<Integer> track = new ArrayList<Integer>();

        backpack(0, nums, track, res);

        return res;
    }

    public void backpack(int start, int[] nums, List<Integer> track, List<List<Integer>> res)
    {
        res.add(new ArrayList<Integer>(track));

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backpack(i + 1, nums, track, res);
            track.remove(track.size() - 1);
        }

    }
}
