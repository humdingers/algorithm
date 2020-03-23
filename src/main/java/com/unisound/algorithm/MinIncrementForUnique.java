package com.unisound.algorithm;

//使数组唯一的最小增量
/*
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。

    返回使 A 中的每个值都是唯一的最少操作次数。
    
    示例 1:
    
    输入：[1,2,2]
    输出：1
    解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 */
//计数排序O(N)
public class MinIncrementForUnique
{
    public int minIncrementForUnique(int[] A)
    {
        // counter数组统计每个数字的个数。
        // （这里为了防止下面遍历counter的时候每次都走到40000，所以设置了一个max，这个数据量不设也行，再额外设置min也行）
        int[] counter = new int[40001];
        int max = -1;
        for (int num : A) {
            counter[num]++;
            max = Math.max(max, num);
        }

        // 遍历counter数组，若当前数字的个数cnt大于1个，则只留下1个，其他的cnt-1个后移
        int move = 0;
        for (int num = 0; num <= max; num++) {
            if (counter[num] > 1) {
                int d = counter[num] - 1;
                move += d;
                counter[num + 1] += d;
            }
        }
        // 最后, counter[max+1]里可能会有从counter[max]后移过来的，counter[max+1]里只留下1个，其它的d个后移。
        // 设 max+1 = x，那么后面的d个数就是[x+1,x+2,x+3,...,x+d],
        // 因此操作次数是[1,2,3,...,d],用求和公式求和。
        int d = counter[max + 1] - 1;
        move += (1 + d) * d / 2;
        return move;
    }

}
