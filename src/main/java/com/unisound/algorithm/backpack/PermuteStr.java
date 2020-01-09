package com.unisound.algorithm.backpack;

import java.util.ArrayList;
import java.util.List;

//全排列
public class PermuteStr
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
