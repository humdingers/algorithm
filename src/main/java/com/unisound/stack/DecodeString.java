package com.unisound.stack;

import java.util.LinkedList;

/*
  * 给定一个经过编码的字符串，返回它解码后的字符串。
    
    编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
    
    你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
    
    此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
    
    示例:
    
    s = "3[a]2[bc]", 返回 "aaabcbc".
    s = "3[a2[c]]", 返回 "accaccacc".
    s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class DecodeString
{
    public String decodeString(String s)
    {
        // 跟有效的括号类似，利用后入先出的准则需要从内向外生成与拼接字符串
        int multi = 0;
        LinkedList<String> stack_res = new LinkedList<String>();
        LinkedList<Integer> stack_multi = new LinkedList<Integer>();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = 10 * multi + Integer.valueOf(c + ""); // 记录倍数

            } else {
                res.append(c);

            }

        }

        return res.toString();

    }

}
