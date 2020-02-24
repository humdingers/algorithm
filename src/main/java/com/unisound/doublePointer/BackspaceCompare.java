package com.unisound.doublePointer;

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
    // 重构字符串
    public boolean backspaceCompare(String S, String T)
    {
        // 比较重构后的字符串
        return build(S).equals(build(T));

    }

    public String build(String str)
    {
        Stack<Character> tmp = new Stack<Character>();
        for (Character c : str.toCharArray()) {
            // 不是退格符'#'就进栈
            if (!c.equals('#')) {
                tmp.push(c);
                // 遇到退格符时，就出栈一个字符代表删除前一个字符
            } else if (!tmp.isEmpty()) {
                tmp.pop();
            }
        }

        return tmp.toString();

    }

    // 反向遍历字符串，如果遍历到一个退格符，那么再往左第一个非退格字符将会被删除，剩余未被删除的字符就是最终的字符串。
    public boolean backspaceCompareDp(String S, String T)
    {
        int i = S.length() - 1;
        int j = T.length() - 1;

        // 分别记录两个字符串的退格数
        int skipi = 0;
        int skipj = 0;
        while (i >= 0 && j >= 0) {
            while (i >= 0) { // 循环的作用为了多删除前面一个字符
                if (S.charAt(i) == '#') {
                    i--;
                    skipi++; // 记录要删除的字符数
                } else if (skipi > 0) { // 删除字符
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

            // 删除结束时开始一一比较
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;

            }

            // 如果一方为空，另一方不为空
            if ((i == -1) != (j == -1)) {
                return false;
            }

            i--;
            j--;

        }

        return true;

    }

}
