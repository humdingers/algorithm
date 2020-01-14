package com.unisound.greedy;

// 最长回文串

/*
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

        在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
        
        注意:
        假设字符串的长度不会超过 1010。
        
        示例 1:
        
        输入:
        "abccccdd"
        
        输出:
        7
 */

/*
 * 对于每个字母，假设它出现了 v 次。我们可以让 v // 2 * 2 个字母左右对称。
 * 例如，对于字符串 'aaaaa'，其中 'aaaa' 是左右对称，其长度为 5 // 2 * 2 = 4。

    最后，如果有任何一个满足 v % 2 == 1 的 v，那么这个字符就可能是回文串中唯一的那个中心。
    针对这种情况，我们需要判断 v % 2 == 1 && ans % 2 == 0，后面的判断主要是为了防止重复计算

 */
public class LongestPalindrome
{

    public int longestPalindrome(String s)
    {
        int[] count = new int[128];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int res = 0;

        for (int num : count) {
            res += num / 2 * 2; // 回文串是左右相等，*2左右对称个数，/2 消除奇数的情况

            if (num % 2 == 1 && res % 2 == 0) {// 回文串只能有唯一的那个中心。
                // res % 2 == 0为了防止前面已经订好了中心，防止重复计算，
                res++;
            }

        }

        return res;

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
