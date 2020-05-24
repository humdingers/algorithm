package com.unisound.doublePointer;

/*
 * 面试题 10.01. 合并排序的数组
    给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
    
    初始化 A 和 B 的元素数量分别为 m 和 n。
    
    示例:
    
    输入:
    A = [1,2,3,0,0,0], m = 3
    B = [2,5,6],       n = 3
    
    输出: [1,2,2,3,5,6]
 */
/*
 * 使用 p1 和 p2  两个指针分别指向 A 和 B 的末端，每次将较大的数填充到 A 的末尾即可。

        当 A 已经填充完毕而 B 还有剩余时，直接将 B 的剩余部分填充到 A 的头部。

 */
//时间复杂度：O(m+n)
public class Merge
{

    public void merge(int[] A, int m, int[] B, int n)
    {
        int p1 = m - 1;
        int p2 = n - 1;

        int cur = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            A[cur--] = A[p1] > B[p2] ? A[p1--] : B[p2--];
        }

        while (p2 >= 0) {
            A[cur--] = B[p2--];
        }

    }

}
