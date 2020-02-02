package com.unisound.backpack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//子集
/*
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

    说明：解集不能包含重复的子集。
    
    示例:
    
    输入: [1,2,2]
    输出:
    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]

 */
public class SubsetsWithDup
{
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums); // 排序
        getAns(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void getAns(int[] nums, int start, ArrayList<Integer> track, List<List<Integer>> ans)
    {
        ans.add(new ArrayList<Integer>(track));
        for (int i = start; i < nums.length; i++) {
            // 和上个数字相等就跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            getAns(nums, i + 1, track, ans); // 子集和全排列系列问题不同，
            // 全排列需要固定size大小的track，子集不是，所以当前用过的元素下轮不需要包含，所以此时为i+1
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
