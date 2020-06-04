package com.unisound.backpack;

import java.util.ArrayList;
import java.util.List;

/*
 * 784. 字母大小写全排列
    给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
    
    示例:
    输入: S = "a1b2"
    输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
    
    输入: S = "3z4"
    输出: ["3z4", "3Z4"]
    
    输入: S = "12345"
    输出: ["12345"]
 */
//时间和空间复杂度：O(2^N∗N)
public class LetterCasePermutation
{
    public List<String> letterCasePermutation(String S)
    {
        int len = S.length();

        List<String> res = new ArrayList<String>();
        if (len == 0) {
            return res;
        }

        char[] arr = new char[len];
        backpack(S, 0, len, arr, res);

        return res;

    }

    public void backpack(String S, int start, int len, char[] arr, List<String> res)
    {
        if (start == len) {
            res.add(new String(arr));
            return;
        }

        arr[start] = S.charAt(start);
        // 控制递归完整个字符串
        backpack(S, start + 1, len, arr, res);
        // 如果是字符，就可以派生出一个新分支
        if (Character.isLetter(S.charAt(start))) {
            // 变换大小写这件事等价于：

            // 1、如果字符是小写字符，减去 32 得到大写字符；
            // 2、如果字符是大写字符，加上 32 得到小写字符。

            // 而这两者合并起来，就是给这个字符做一次不进位的加法，即异或上 1 << 5。
            // 这一步直接修改，相当于回溯
            // 再对每个字符调整
            arr[start] = (char) (S.charAt(start) ^ (1 << 5));
            // arr[start] ^= (1 << 5);
            backpack(S, start + 1, len, arr, res);

        }

    }

}
