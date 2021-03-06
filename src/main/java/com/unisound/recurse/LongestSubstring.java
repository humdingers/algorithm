package com.unisound.recurse;

/*
 * 395. 至少有K个重复字符的最长子串
找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。

示例 1:

输入:
s = "aaabb", k = 3

输出:
3

最长子串为 "aaa" ，其中 'a' 重复了 3 次。
示例 2:

输入:
s = "ababbc", k = 2

输出:
5

最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 */

/*
 * 递归拆分子串，分治。先统计出每个字符出现的频次，维护一对双指针，从首尾开始统计，
 * 从首尾往中间排除，如果出现次数小于k则不可能出现在最终子串中，排除并挪动指针，
 * 然后得到临时子串，依次从头遍历，一旦发现出现频次小于k的字符，以该字符为分割线，分别递归求其最大值返回

 */
public class LongestSubstring
{
    public int longestSubstring(String s, int k)
    {
        int len = s.length();
        if (len == 0 || k > len) {
            return 0;

        }

        if (k < 2) {
            return len;
        }

        return divideCount(s.toCharArray(), k, 0, len - 1);
    }

    public int divideCount(char[] arr, int k, int p1, int p2)
    {
        // 从两端删除，剩下的长度不足以构成k
        if (p2 - p1 + 1 < k) {
            return 0;
        }

        int[] count = new int[26];

        // 统计M每次p1-p2之间出现频次
        for (int i = p1; i <= p2; i++) {
            ++count[arr[i] - 'a'];
        }

        // 如果该字符出现频次小于k，则不可能出现在结果子串中
        // 分别排除，然后挪动两个指针

        while (p2 - p1 + 1 >= k && count[arr[p1] - 'a'] < k) {
            p1++;
        }

        while (p2 - p1 + 1 >= k && count[arr[p2] - 'a'] < k) {
            p2--;
        }

        if (p2 - p1 + 1 < k) {
            return 0;
        }

        for (int i = p1; i <= p2; i++) {
            // 得到临时子串，再递归处理
            // 如果第i个不符合要求，切分成左右两段分别递归求得
            if (count[arr[i] - 'a'] < k) {
                // 此时为i-1，因为分割点不可能在p1和p2
                return Math.max(divideCount(arr, k, p1, i - 1), divideCount(arr, k, i + 1, p2));
            }
        }

        return p2 - p1 + 1;
    }

}
