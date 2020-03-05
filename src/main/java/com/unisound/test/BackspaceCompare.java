package com.unisound.test;

import java.util.Stack;

//退格字符
/*
* 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

 

      示例 1：
      
      输入：S = "ab#c", T = "ad#c"
      输出：true
      解释：S 和 T 都会变成 “ac”。
      示例 2：

*/

public class BackspaceCompare
{ // 重构字符串
    public boolean backspaceCompare(String S, String T)
    {
        return build(S).equals(build(T));

    }

    public String build(String str)
    {
        Stack<Character> tmp = new Stack<Character>();

        for (char c : str.toCharArray()) {
            if (c != '#') {
                tmp.push(c);
            } else if (!tmp.isEmpty()) {
                tmp.pop();
            }
        }
        return tmp.toString();

    }

}
