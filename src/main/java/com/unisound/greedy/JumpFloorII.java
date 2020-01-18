package com.unisound.greedy;

//变态跳台阶
/*
 *

假设跳 n 级台阶的跳法数量是 f(n)个。

那么根据题意，青蛙可能从 n-1 级直接跳上来，也可能从 n-2 级直接跳上来，依次类推：f(n) = f(n - 1) + f(n - 2) + ... + f(1)

同理：f(n - 1) = f(n - 2) + f(n - 3) + ... + f(1)

所以，将公式 1 中的f(n - 2) + f(n - 3) + ... + f(1)替换为f(n - 1)。公式 1 变为：f(n) = f(n - 1) + f(n - 1) = f(n - 1) * 2 （公式 3）

同理：f(n - 1) = f(n - 2) + f(n - 2) = f(n - 2) * 2（公式 4）

结合公式 3 和公式 4: f(n) = f(n - 2) * 2 * 2。因此可以推出：f(n) = 2^(n - 1)
 */
public class JumpFloorII
{

    public class Solution
    {
        public int JumpFloorII(int target)
        {
            return 1 << (target - 1);
            // return (int)Math.pow(2,target-1);
        }
    }

}
