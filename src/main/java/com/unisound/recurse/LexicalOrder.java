package com.unisound.recurse;

import java.util.ArrayList;
import java.util.List;

/*
 * 386. 字典序排数
    给定一个整数 n, 返回从 1 到 n 的字典顺序。
    
    例如，
    
    给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
    
    请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 */
/*
 * DFS第一层调用时只能有1-9可以选择，
    在第二层及以后的调用可以选择0-9。
 */
public class LexicalOrder
{
    public List<Integer> lexicalOrder(int n)
    {
        List<Integer> res = new ArrayList<Integer>();
        order(res, n, 0);

        return res;

    }

    public void order(List<Integer> res, int maxnum, int cur)
    {
        // 不能超过n
        if (cur > maxnum) {
            return;
        }

        // 不能等于0
        if (cur > 0) {
            res.add(cur);
        }

        // 第一位不能为0；剩下几位可以是0
        for (int i = 0; i <= 9; i++) {
            if (cur == 0) {
                if (i == 0) {
                    continue;
                }

            }

            order(res, maxnum, cur * 10 + i);
        }
    }

}
