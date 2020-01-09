package com.unisound.algorithm;

//最长公共前缀
/*
 * 编写一个函数来查找字符串数组中的最长公共前缀。

    如果不存在公共前缀，返回空字符串 ""。
    
    示例 1:
    
    输入: ["flower","flow","flight"]
    输出: "fl"

。
 */
public class CommonPrefix
{
    public String longestCommonPrefix(String[] strs)
    {
        if (null == strs || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    public boolean isCommonPrefix(String[] strs, int mid)
    {
        String str = strs[0].substring(0, mid);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str)) {
                return false;
            }
        }
        return true;
    }

}
