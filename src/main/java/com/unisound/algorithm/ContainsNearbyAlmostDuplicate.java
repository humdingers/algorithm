package com.unisound.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//存在重复元素 III
/*
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 
 * 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。

    示例 1:
    
    输入: nums = [1,2,3,1], k = 3, t = 0
    输出: true

 */
public class ContainsNearbyAlmostDuplicate
{
    private long getID(long x, long w)
    {
        return (x < 0) ? (x + 1) / w - 1 : x / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    {
        if (t < 0)
            return false;

        Map<Long, Long> tmp = new HashMap<Long, Long>();

        long m = (long) t + 1;

        for (int i = 0; i < nums.length; i++) {
            long id = getID(nums[i], m);
            if (tmp.containsKey(id)) {
                return true;
            }

            if (tmp.containsKey(id - 1) && Math.abs(nums[i] - tmp.get(id - 1)) < m) {
                return true;
            }

            if (tmp.containsKey(id + 1) && Math.abs(nums[i] - tmp.get(id + 1)) < m) {
                return true;
            }

            tmp.put(id, (long) nums[i]);

            if (i >= k) {
                tmp.remove(getID(nums[i - k], m));
            }

        }
        return false;

    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t)
    {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Long> window = new HashSet<Long>();

        for (int i = 0; i < nums.length; i++) {
            if (t == 0) {
                if (window.contains((long) nums[i])) {
                    return true;
                }
            } else {
                for (long tmp : window) {
                    if (Math.abs(tmp - nums[i]) <= t) {
                        return true;
                    }

                }

            }

            window.add((long) nums[i]);

            if (window.size() > k) {
                window.remove((long) nums[i - k]);
            }

        }

        return false;
    }

    public static void main(String[] args)
    {

    }

}
