package com.unisound.binarySearch;

//最长公共前缀
/*
 * 编写一个函数来查找字符串数组中的最长公共前缀。

    如果不存在公共前缀，返回空字符串 ""。
    
    示例 1:
    
    输入: ["flower","flow","flight"]
    输出: "fl"

。
 */
/*
 *  算法的查找区间是 (0 - minLen)(0…minLen)，其中 minLen 是输入数据中最短的字符串的长度，同时也是答案的最长可能长度。 
 *  每一次将查找区间一分为二，然后丢弃一定不包含最终答案的那一个。算法进行的过程中一共会出现两种可能情况：
    
    S[1...mid] 不是所有串的公共前缀。 这表明对于所有的 j > i S[1..j] 也不是公共前缀，于是我们就可以丢弃后半个查找区间。
    
    S[1...mid] 是所有串的公共前缀。 这表示对于所有的 i < j S[1..i] 都是可行的公共前缀，因为我们要找最长的公共前缀，
    所以我们可以把前半个查找区间丢弃。

 */
public class CommonPrefix
{
    public static String longestCommonPrefix(String[] strs)
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
        return strs[0].substring(0, (low + high) / 2); // 闭区间，正好在mid位置
    }

    public static boolean isCommonPrefix(String[] strs, int mid)
    {
        String str = strs[0].substring(0, mid);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        String[] strs = new String[] {"dddd", "fff"};
        System.out.print(longestCommonPrefix(strs));
        String aa = "gggg";
        System.out.print(aa.substring(0, 0));
    }

}
