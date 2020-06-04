package com.unisound.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * /*
 * 491. 递增子序列
    给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
    
    示例:
    
    输入: [4, 6, 7, 7]
    输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 */
//n*2^n)

public class FindSubsequences
{
    public List<List<Integer>> findSubsequences(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums.length == 0) {
            return res;
        }

        List<Integer> track = new ArrayList<Integer>();

        backpack(nums, track, 0, res);

        return res;

    }

    public void backpack(int[] nums, List<Integer> track, int start, List<List<Integer>> res)
    {
        if (track.size() >= 2) {
            res.add(new ArrayList<Integer>(track));
        }

        Set<Integer> tmp = new HashSet<Integer>();
        for (int i = start; i < nums.length; i++) {
            if (tmp.contains(nums[i])) {
                continue;
            }

            if (track.size() == 0 || nums[i] >= track.get(track.size() - 1)) {
                track.add(nums[i]);
                tmp.add(nums[i]);
                backpack(nums, track, i + 1, res);

                track.remove(track.size() - 1);

            }
        }

    }

}
