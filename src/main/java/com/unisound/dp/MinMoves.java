package com.unisound.dp;

import java.util.Arrays;

/*
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。

    示例:
    
    输入:
    [1,2,3]
    
    输出:
    3
    
    解释:
    只需要3次移动（注意每次移动会增加两个元素的值）：
    
    [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

 */
/*
 * 首先，假设我们在每一步计算 diff 之后正在更新有序数组的元素。下面展示如何在不遍历数组的情况下找到最大最小值。在第一步中，最后的元素即为最大值，因此 diff=a[n-1]-a[0]。我们对除了最后一个元素以外所有元素增加 diff。

现在，更新后的数组开头元素 a'[0] 变成了 a[0]+diff=a[n-1]。因此，a'[0] 等于上一步中最大的元素 a[n-1]。由于数组排过序，直到 i-2 的元素都满足 a[j]>=a[j-1]。因此，更新之后，a'[n-2] 即为最大元素。而 a[0] 依然是最小元素。

于是，在第二次更新时，diff=a[n-2]-a[0]。更新后 a''[0] 会成为 a'[n-2]，与上一次迭代类似。

然后，由于 a'[0] 和 a'[n-1] 相等，在第二次更新后，a''[0]=a''[n-1]=a'[n-2]。于是，最大的元素为 a[n-3]。

于是，我们可以继续这样，在每一步用最大最小值差更新数组。

下面进入第二步。第一步中，我们假设每一步会更新数组 a 中的元素。但事实上，我们不需要这么做。这是因为，即使是在更新元素之后，我们要登记的 diff 差值也不变，因为 max 和 min 增加的数字相同。

于是，我们可以简单的将数组排序一次，oves=∑ i=1 n−1(a[i]−a[0])。

 */
//时间复杂度：O(nlog(n))
public class MinMoves
{
    public int minMoves(int[] nums)
    {
        Arrays.sort(nums);

        int count = 0;

        for (int i = nums.length - 1; i >= 1; i--) {
            count += nums[i] - nums[0];
        }

        return count;
    }

    public int minMovesMath(int[] nums)
    {
        int moves = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i] - min;
        }
        return moves;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
