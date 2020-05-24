package com.unisound.presum;

/*
 * 974. 和可被 K 整除的子数组
    给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
    
     
    
    示例：
    
    输入：A = [4,5,0,-2,-3,1], K = 5
    输出：7
    解释：
    有 7 个子数组满足其元素之和可被 K = 5 整除：
    [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 */
/*
 * 
 * 同余定理：如果两个整数 a, b 满足 (a-b)%K == 0，那么有 a%K == b%K。
由此可知,如果 i，j 满足 (prefix(j) - prefix(i-1))%K == 0，那么有 prefix(i)%K == prefix(i-1)%K。
故，可以扫描一遍前缀和 prefix，利用 count 统计所有余数出现的次数，然后遍历 count 利用组合公式C(n,m) = n!/((n-m)!*m!) 来计算答案。
此时时间复杂度降到了 O(n)。

 */
public class SubarraysDivByK
{
    public int subarraysDivByK(int[] A, int K)
    {
        int n = A.length;

        A[0] %= K;

        for (int i = 1; i < n; i++) {
            A[i] = (A[i - 1] + A[i]) % K;
        }

        int[] count = new int[K];

        // 对count中次数两两一对，进行组合
        // count[0] = 1，可以解释为在sum数组的前面加一个 0（或 k），
        // 从而将原本数组中余数为0的数与之关联，计算到结果中，多出来的这部分计算结果正好填补了上面提到的缺失的单独子数组。
        count[0] = 1;

        for (int num : A) {
            // num % K + K 负数取余数 的情况
            count[(num % K + K) % K]++;
        }

        int ans = 0;
        for (int c : count) {
            ans += (c * (c - 1)) / 2;
        }

        return ans;

    }

}
