package com.unisound.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 436. 寻找右区间
    给定一组区间，对于每一个区间 i，检查是否存在一个区间 j，它的起始点大于或等于区间 i 的终点，这可以称为 j 在 i 的“右侧”。
    
    对于任何区间，你需要存储的满足条件的区间 j 的最小索引，这意味着区间 j 有最小的起始点可以使其成为“右侧”区间。如果区间 j 不存在，则将区间 i 存储为 -1。最后，你需要输出一个值为存储的区间值的数组。
    
    注意:
    
    你可以假设区间的终点总是大于它的起始点。
    你可以假定这些区间都不具有相同的起始点。
    示例 1:
    
    输入: [ [1,2] ]
    输出: [-1]
    
    解释:集合中只有一个区间，所以输出-1。
    示例 2:
    
    输入: [ [3,4], [2,3], [1,2] ]
    输出: [-1, 0, 1]
    
    解释:对于[3,4]，没有满足条件的“右侧”区间。
    对于[2,3]，区间[3,4]具有最小的“右”起点;
    对于[1,2]，区间[2,3]具有最小的“右”起点。
 */

/*
 * 因此在预处理的时候，就得把“起点”和“索引”的关系存起来。

刚刚好题目中说道：“你可以假定这些区间都不具有相同的起始点”，用哈希表正合适。
4、排序的时候，只需要对起点进行排序即可；

5、在二分查找的时候，传入的是区间的右端点，查找的是大于等于区间的右端点的第 1 个值，因此它的反面就是：小于一定不是解。根据这个“减而治之”的策略，编写二分查找算法。
//O((n.log(n))
 */
public class FindRightInterval
{
    public int[] findRightInterval(int[][] intervals)
    {
        int len = intervals.length;
        if (len == 0) {
            return new int[0];
        }

        int[] res = new int[len];
        int[] tmp = new int[len];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < len; i++) {
            tmp[i] = intervals[i][0];
            map.put(intervals[i][0], i);
        }

        Arrays.sort(tmp);

        for (int i = 0; i < len; i++) {
            int index = search(tmp, intervals[i][1]);

            if (index == -1) {
                res[i] = -1;
            } else {
                res[i] = map.get(index);
            }

        }

        return res;

    }

    public int search(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length;

        if (target > nums[nums.length - 1]) {
            return -1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

}
