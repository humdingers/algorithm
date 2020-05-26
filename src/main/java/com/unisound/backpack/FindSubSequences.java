package com.unisound.backpack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 491. 递增子序列
    给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
    
    示例:
    
    输入: [4, 6, 7, 7]
    输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 */
//n*2^n)
public class FindSubSequences
{

    public List<List<Integer>> findSubsequences(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == 0) {
            return res;
        }

        List<Integer> track = new ArrayList<>();
        dfs(nums, track, res, 0);
        return res;
    }

    public void dfs(int[] nums, List<Integer> track, List<List<Integer>> res, int depth)
    {

        if (track.size() >= 2) {
            res.add(new ArrayList<>(track));
        }
        Set<Integer> tmp = new HashSet<Integer>();
        for (int i = depth; i < nums.length; i++) {
            // 通过set保证如果nums[i]后面的元素与nums[i]相同，通过set过滤，保证不会有重复的路径添加
            if (tmp.contains(nums[i])) {
                continue;
            }
            // 当track的容量为0，或者track的容量大于0且新加入的元素大于track的最后一个元素，才将新元素加入track 这样保证递增
            if (track.size() == 0 || nums[i] >= track.get(track.size() - 1)) {

                tmp.add(nums[i]);
                track.add(nums[i]);
                dfs(nums, track, res, i + 1);
                track.remove(track.size() - 1);
            }

        }
    }

}
