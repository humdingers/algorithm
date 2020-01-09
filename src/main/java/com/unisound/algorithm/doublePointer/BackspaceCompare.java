package com.unisound.algorithm.doublePointer;

//退格字符
/*
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

 

        示例 1：
        
        输入：S = "ab#c", T = "ad#c"
        输出：true
        解释：S 和 T 都会变成 “ac”。
        示例 2：

 */
import java.util.Stack;

public class BackspaceCompare
{
    public boolean backspaceCompare(String S, String T)
    {
        return build(S).equals(build(T));

    }

    public String build(String str)
    {
        Stack<Character> tmp = new Stack<Character>();
        for (Character c : str.toCharArray()) {
            if (!c.equals('#')) {
                tmp.push(c);
            } else if (!tmp.isEmpty()) {
                tmp.pop();
            }
        }

        return tmp.toString();

    }

    public boolean backspaceCompareDp(String S, String T)
    {
        int i = S.length() - 1;
        int j = S.length() - 1;

        int skipi = 0;
        int skipj = 0;
        while (i >= 0 && j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    i--;
                    skipi++;
                } else if (skipi > 0) {
                    i--;
                    skipi--;
                } else {
                    break;
                }

            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    j--;
                    skipj++;
                } else if (skipj > 0) {
                    j--;
                    skipj--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;

            }

            if ((i == -1) != (j == -1)) {
                return false;
            }

            i--;
            j--;

        }

        return true;

    }

}
