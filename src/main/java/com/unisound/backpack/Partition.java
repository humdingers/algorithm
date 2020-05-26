package com.unisound.backpack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * 131. 分割回文串
    给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
    
    返回 s 所有可能的分割方案。
    
    示例:
    
    输入: "aab"
    输出:
    [
      ["aa","b"],
      ["a","a","b"]
    ]
 */
/*
 * 产生前缀字符串的时候，判断前缀字符串是否是回文。

如果前缀字符串是回文，则可以产生分支和结点；
如果前缀字符串不是回文，则不产生分支和结点，这一步是剪枝操作。
3、在叶子结点是空字符串的时候结算，此时从根结点到叶子结点的路径，就是结果集里的一个结果，使用深度优先遍历，记录下所有可能的结果。
n*2^(n)
 */
public class Partition
{
    public List<List<String>> partition(String s)
    {
        int len = s.length();

        List<List<String>> res = new ArrayList<List<String>>();

        if (len == 0) {
            return res;
        }

        Deque<String> track = new ArrayDeque<String>();
        backpack(s, res, track, 0);

        return res;

    }

    public void backpack(String s, List<List<String>> res, Deque<String> track, int start)
    {
        if (start == s.length()) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (!istrue(s, start, i)) {
                continue;
            }
            track.addLast(s.substring(start, i + 1));
            backpack(s, res, track, i + 1);
            track.removeLast();

        }

    }
    // 判断是不是回文

    public boolean istrue(String s, int left, int right)
    {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

}
