package com.unisound.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

    注意：答案中不可以包含重复的三元组。
    
    例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    
    满足要求的三元组集合为：
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]

 */
public class ThreeSums
{
    public static List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        int len = nums.length;

        if (nums == null || len < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[left]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

                left++;
                right--;
            }
        }

        return res;

    }

}
