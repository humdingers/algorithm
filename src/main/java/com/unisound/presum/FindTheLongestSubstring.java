package com.unisound.presum;

import java.util.Arrays;

/*
 * 1371. 每个元音包含偶数次的最长子字符串
    给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
    
     
    
    示例 1：
    
    输入：s = "eleetminicoworoep"
    输出：13
    解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
    示例 2：
    
    输入：s = "leetcodeisgreat"
    输出：5
    解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 */
public class FindTheLongestSubstring
{
    public int findTheLongestSubstring(String s)
    {
        int n = s.length();

        int ans = 0;

        String select = "aeiou";

        int[] dp = new int[1 << 5]; // 2^5种状态

        Arrays.fill(dp, Integer.MAX_VALUE);

        // 初始转态为00000
        dp[0] = 0;
        int state = 0;

        // 注意i的起始
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k < 5; k++) {
                // 00000初始状态
                // 00001 代表a 00010 代表e 00100代表i 01000代表o 10000代表u
                if (s.charAt(i - 1) == select.charAt(k)) {
                    state ^= (1 << k);
                    break;
                }
            }

            // 记录某个状态第一次出现的位置
            dp[state] = Math.min(dp[state], i);

            // 如果字符串[0, i]与字符串[0, j]状态相同， 那么字符串[i+1， j]的状态一定为0(出现偶数次， 异或为0)
            // 奇数-奇数 = 偶数
            // 偶数 - 偶数 = 偶数

            ans = Math.max(ans, i - dp[state]);

        }

        return ans;

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
