package com.unisound.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//单词拆分
/*
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

    说明：
    
    拆分时可以重复使用字典中的单词。
    你可以假设字典中没有重复的单词。
    示例 1：
    
    输入: s = "leetcode", wordDict = ["leet", "code"]
    输出: true
    解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

 */
//时间复杂度：O(n^2)
public class WorkBreak
{
    public boolean wordBreak(String s, List<String> wordDict)
    {

        Set<String> wordSet = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 0; i <= s.length(); i++) { // 此时的字符串状态为i的位置结尾
            for (int j = 0; j < i; j++) {
                // 找i之前的位置j,是否存在j的位置状态为true,说明可以从j将0-i的字符串拆分
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }

        }
        return dp[s.length()];

    }

}
