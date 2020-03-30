package com.unisound.test;

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

        int maxValue = 0;
        int maxLetter = 0;

        for (char c : S.toCharArray()) {
            tmp[c - 'a']++;
        }

        int index = 0;
        for (int count : tmp) {
            if (count > maxValue) {
                maxValue = count;
                maxLetter = index;
            }
            index += 1;
        }

        if (maxValue > (S.length() + 1) / 2) {
            return "";
        }

        char[] res = new char[S.length()];

        int indice = 0;
        while (tmp[maxLetter] > 0) {
            res[indice] = (char) (maxLetter + 'a');
            tmp[maxLetter]--;
            indice += 2;
        }

        for (int i = 0; i < tmp.length; i++) {
            while (tmp[i] > 0) {
                if (indice >= S.length()) {
                    indice = 1;
                }

                res[indice] = (char) (i + 'a');
                tmp[i]--;
                indice += 2;
            }

        }

        return String.valueOf(res);
    }

}
