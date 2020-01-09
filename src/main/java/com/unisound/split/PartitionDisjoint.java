package com.unisound.split;

//分割数组
/*
 * 给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：

    left 中的每个元素都小于或等于 right 中的每个元素。
    left 和 right 都是非空的。
    left 要尽可能小。
    在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
    
     
    
    示例 1：
    
    输入：[5,0,3,8,6]
    输出：3
    解释：left = [5,0,3]，right = [8,6]

 */
public class PartitionDisjoint
{
    public static int partitionDisjoint(int[] A)
    {
        int N = A.length;
        // 构建两个辅助数组
        // 一个记录从左到右的最大值
        // 另一个记录从右到左的最小值
        int[] maxleft = new int[N];
        int[] minright = new int[N];

        int m = A[0];
        for (int i = 0; i < N; ++i) {
            m = Math.max(m, A[i]);
            maxleft[i] = m;
        }

        m = A[N - 1];
        for (int i = N - 1; i >= 0; --i) {
            m = Math.min(m, A[i]);
            minright[i] = m;
        }

        for (int i = 1; i < N; ++i)
            if (maxleft[i - 1] <= minright[i])
                return i;

        throw null;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] {5, 4, 5, 8, 6, 7};
        System.out.print(partitionDisjoint(nums));

    }

}
