package com.unisound.backpack;

import java.util.ArrayList;
import java.util.List;

//全排列
/*
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。

        示例:
        
        输入: [1,2,3]
        输出:
        [
          [1,2,3],
          [1,3,2],
          [2,1,3],
          [2,3,1],
          [3,1,2],
          [3,2,1]
        ]
 */
public class Permute
{

    public static List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> track = new ArrayList<Integer>();
        backtrack(nums, track, ans);
        return ans;

    }

    public static void backtrack(int[] nums, List<Integer> track, List<List<Integer>> ans)
    {
        if (track.size() == nums.length) {
            ans.add(new ArrayList<Integer>(track));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (track.contains(nums[i]))
                    continue;
                track.add(nums[i]);
                backtrack(nums, track, ans);
                track.remove(track.size() - 1); // 注意
            }
        }

    }

    public static void main(String[] args)
    {
        int[] nums = new int[] {1, 2, 3};
        System.out.print(permute(nums));

    }

}
