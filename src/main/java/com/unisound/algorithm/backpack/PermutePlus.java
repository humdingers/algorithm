package com.unisound.algorithm.backpack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// 全排列
public class PermutePlus
{
    public List<List<Integer>> permute(int[] nums)
    {
        // init output list
        List<List<Integer>> output = new LinkedList<List<Integer>>();

        List<Integer> num_list = new ArrayList<Integer>();

        for (int num : nums) {
            num_list.add(num);
        }

        int n = nums.length;

        backpack(n, output, num_list, 0);

        return output;

    }

    public void backpack(int n, List<List<Integer>> output, List<Integer> num_list, int first)
    {
        if (first == n) {
            output.add(new ArrayList<Integer>(num_list));
        }

        for (int i = first; i < n; i++) {
            Collections.swap(num_list, first, i);

            backpack(n, output, num_list, first + 1);

            Collections.swap(num_list, first, i);

        }

    }

}
