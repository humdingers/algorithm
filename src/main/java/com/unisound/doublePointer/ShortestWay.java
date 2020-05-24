package com.unisound.doublePointer;

/*
 * 形成字符串的最短路径

    对于任何字符串，我们可以通过删除其中一些字符（也可能不删除）来构造该字符串的子序列。
    
    给定源字符串 source 和目标字符串 target，找出源字符串中能通过串联形成目标字符串的子序列的最小数量。如果无法通过串联源字符串中的子序列来构造目标字符串，则返回 -1。
    
    示例 1：
    
    输入：source = "abc", target = "abcbc" 
    输出：2 
    解释：目标字符串 "abcbc" 可以由 "abc" 和 "bc" 形成，它们都是源字符串 "abc" 的子序列。
    示例 2：
    
    输入：source = "abc", target = "acdbc"
    输出：-1
    解释：由于目标字符串中包含字符 "d"，所以无法由源字符串的子序列构建目标字符串。
 */
public class ShortestWay
{
    public int shortestWay(String source, String target)
    {
        if (source == null || target == null) {
            return -1;
        }

        if (target.length() == 0) {
            return 0;
        }

        int m = source.length();
        int n = target.length();

        int cur = 0;
        int res = 0;

        while (cur < n) {
            int tmp = cur;

            for (int i = 0; i < m && cur < n; i++) {
                if (source.charAt(i) == target.charAt(cur)) {
                    cur++;
                }
            }

            if (tmp == cur) {
                return -1;

            }

            res++;
        }

        return res;

    }

}
