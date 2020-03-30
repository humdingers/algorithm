package com.unisound.doublePointer;

// 字符串压缩
/*
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
    
    示例1:
    
     输入："aabcccccaaa"
     输出："a2b1c5a3"

 */
public class CompressString
{
    public String compressString(String S)
    {
        int N = S.length();

        int i = 0;
        int j = 0;

        StringBuilder sb = new StringBuilder();
        while (i < N) {
            j = i;

            while (j < N && S.charAt(j) == S.charAt(i)) {
                j++;
            }
            sb.append(S.charAt(i));
            sb.append(j - i);

            i = j;
        }

        if (sb.length() < S.length()) {
            return sb.toString();
        } else {
            return S;
        }

    }

}
