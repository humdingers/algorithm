package com.unisound.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//全排列
/*
* 给定一个可包含重复数字的序列，返回所有不重复的全排列。

  示例:
  
  输入: [1,1,2]
  输出:
  [
    [1,1,2],
    [1,2,1],
    [2,1,1]
  ]

*/
public class PermuteUnique
{
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        List<Integer> track = new ArrayList<Integer>();

        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);
        backpack(res, track, nums, used);
        return res;

    }

    public void backpack(List<List<Integer>> res, List<Integer> track, int[] nums, boolean[] used)
    {
        if (track.size() == nums.length) {
            res.add(new ArrayList<Integer>(track));
        }

        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }

                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                track.add(nums[i]);
                backpack(res, track, nums, used);
                track.remove(track.size() - 1);
                used[i] = false;

            }
        }
    }

}
