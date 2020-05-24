package com.unisound.test;

import java.util.Arrays;

//最长递增子序列的个数
/*
* 给定一个未排序的整数数组，找到最长递增子序列的个数。

示例 1:

输入: [1,3,5,4,7]
输出: 2
解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
示例 2:

输入: [2,2,2,2,2]
输出: 5
解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。

*/

/*
* 采用动态规划的方法来做，
  思路是：
  1. 最长递增的的子序列其实是不知道是以具体哪个元素为结尾的
  2. 所以需要遍历每个元素为结尾的最长子序列
      a. 对于以某个元素为结尾的最长子序列，还是需要再次进行遍历
      b. 假设计算以第j个元素为结尾的最长子序列的个数count和长度length，算法如下
          1) 从i=0开始遍历元素，直至i=j，相当于每次求nums[0],nums[1],...nums[i],nums[j]的最长子序列个数和长度
          2) 等到下一次迭代，如果第i+1的长度是大于第i的长度，则更新状态变量
          3) 规则为：
              i.   nums[j] > nums[i]是必要条件，否则跳到下一个
              ii.  第一种情况是length[j]<length[i]， 那么需要更新为最新的length[j] = length[i] + 1;count[j] = count[i]
              iii. 第二种情况是length[j]==length[i]，那么需要更新为最新的length[j] = length[i] + 1;count[j] = count[i]
              iv.  第三种情况是length[j]==length[i] + 1， 那么需要更新为最新的count[j] = count[i] + count[j]
              v.   第四种情况是length[j]>length[i] + 1，表示nums[0],nums[1],...nums[i],nums[j]序列最长序列还没有上一个i-1的大，所以无需更新
  3. 然后再遍历动态状态变量里面的每个状态，求取其个数。
*/
public class FindNumberOfLIS
{
    public int findNumberOfLIS(int[] nums)
    {
        int len = nums.length;

        if (len <= 1) {
            return len;
        }

        int[] length = new int[nums.length];

        int[] count = new int[nums.length];

        Arrays.fill(count, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] - nums[j] > 0) {
                    if (length[j] >= length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                        // 都是最长长度
                    } else if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }

            }
        }

        int longestLength = 0;

        int ans = 0;

        for (int item : length) {
            longestLength = Math.max(longestLength, item);
        }

        for (int i = 0; i < len; i++) {
            if (length[i] == longestLength) {
                ans += count[i];
            }
        }

        return ans;

    }

}
