package com.unisound.backpack;

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

        Arrays.sort(nums);

        boolean[] flag = new boolean[nums.length];

        backpack(nums, track, res, flag);

        return res;
    }

    public void backpack(int[] nums, List<Integer> track, List<List<Integer>> res, boolean[] flag)
    {
        if (track.size() == nums.length) {
            res.add(new ArrayList<Integer>(track));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (flag[i]) {
                    continue;
                }

                if (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]) {
                    continue;
                }

                track.add(nums[i]);
                flag[i] = true;

                backpack(nums, track, res, flag);

                track.remove(track.size() - 1);
                flag[i] = false;

            }
        }
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
