package com.unisound.backpack;

/*
 * 526. 优美的排列
假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：

第 i 位的数字能被 i 整除
i 能被第 i 位上的数字整除
现在给定一个整数 N，请问可以构造多少个优美的排列？

示例1:

输入: 2
输出: 2
解释: 

第 1 个优美的排列是 [1, 2]:
  第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
  第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除

第 2 个优美的排列是 [2, 1]:
  第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
  第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
 */

/*
 * 我们使用一个使用一个大小为 N 的 “已使用数组” ，
 * 这里 visited[i]表示目前为止第 i 个数字是否已经使用过，True 表示已经使用过， False 表示还没有使用过。

我们使用函数 calculate，它将从 1 到 N 所有还没有被使用过的数字放到当前位置 pos,
并检查是否满足可除性。如果 i放到当前位置 pos 是满足要求的，
我们就把 i 放在当前位置 pos 并继续考虑下一个位置 pos + 1，否则我们需要换一个数字放在当前位置。


 */
//时间复杂度：O(k)。k 是有效排列的数目。
public class CountArrangement
{
    int count = 0;

    public int countArrangement(int N)
    {
        boolean[] visited = new boolean[N + 1];

        backpack(N, 1, visited);

        return count;

    }

    public void backpack(int N, int pos, boolean[] visited)
    {
        if (pos > N) {
            ++count;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                backpack(N, pos + 1, visited);
                visited[i] = false;

            }
        }
    }

}
