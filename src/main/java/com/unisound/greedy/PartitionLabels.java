package com.unisound.greedy;

import java.util.ArrayList;
import java.util.List;

//划分字母区间
/*
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。

    示例 1:
    
    输入: S = "ababcbacadefegdehijhklij"
    输出: [9,7,8]
    解释:
    划分结果为 "ababcbaca", "defegde", "hijhklij"。
    每个字母最多出现在一个片段中。
    像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 */
public class PartitionLabels
{
    public List<Integer> partitionLabels(String S)
    {
        int[] last = new int[26];

        // 记录S中同一个字母最后出现的位置
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<Integer>();
        int start = 0;
        int lastIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            // 对于遇到的每一个字母，去找这个字母最后一次出现的位置，用来更新当前的最小区间。
            // 如果遇到的字符最后一次出现的位置下标大于 j， 就让 j=last[c] 来拓展当前的区间。当遍历到了当前区间的末尾时(即 i==j )，把当前区间加入答案，同时将 start 设为 i+1 去找下一个区间。

            lastIndex = Math.max(lastIndex, last[S.charAt(i) - 'a']);

            if (i == lastIndex) {
                res.add(lastIndex - start + 1);
                start = lastIndex + 1;
            }
        }

        return res;
    }

}
