package com.unisound.greedy;

//重构字符串
/*
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。

    若可行，输出任意可行的结果。若不可行，返回空字符串。
    
    示例 1:
    
    输入: S = "aab"
    输出: "aba"

 */
public class RecorganizeString
{
    // 贪心策略，尽量在偶数位置多放
    public String reorganizeString(String S)
    {
        int[] tmp = new int[26];

        // 存每个字符出现的次数
        for (char c : S.toCharArray()) {
            tmp[c - 'a']++;
        }

        int max = 0;
        int maxLetter = 0;

        // 寻找最大字符数的字符

        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] > max) {
                max = tmp[i];
                maxLetter = i;
            }
        }

        // 如果最大字符数超过字符串一半的长度，那不可能使得相邻字符不同
        if (max > (S.length() + 1) / 2) {
            return "";
        }

        // 构建一个结果数组，存放排列的结果
        char[] res = new char[S.length()];
        int index = 0;

        // 将最大字符数的字符放到结果数组的偶数位置
        while (tmp[maxLetter] > 0) {
            res[index] = (char) (maxLetter + 'a');
            tmp[maxLetter]--; // 注意减去计数

            index += 2;

        }

        // 放置其他的字符
        for (int i = 0; i < tmp.length; i++) {
            // 如果最大字符数的字符还没有放置完全，继续在偶数位置放置字符，直到到达最大长度，改放奇数位置
            while (tmp[i] > 0) {
                if (index >= S.length()) {
                    index = 1;
                }

                res[index] = (char) (i + 'a');
                tmp[i]--; // 注意减去计数

                index += 2;

            }
        }

        return String.valueOf(res);
    }

}
