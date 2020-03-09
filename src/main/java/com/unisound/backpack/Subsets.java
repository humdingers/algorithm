package com.unisound.backpack;

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

//O(N×2^N )
public class Subsets
{
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        List<Integer> track = new ArrayList<Integer>();

        backpack(nums, 0, track, res);

        return res;

    }

    public void backpack(int[] nums, int start, List<Integer> track, List<List<Integer>> res)
    {
        res.add(new ArrayList<Integer>(track));

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            // 子集类问题从i开始
            // 因为并没有说可以重复利用原数组的单个元素去组合子集，所以下一次搜索要从 i + 1 开始，跳过当前元素

            backpack(nums, i + 1, track, res);

            track.remove(track.size() - 1);

        }

    }

}
