package com.unisound.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//有效的括号
/*
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：
    
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。
    
    示例 1:
    
    输入: "()"
    输出: true

 */
public class BucketValid
{
    private Map<Character, Character> mapping;

    public BucketValid()
    {
        mapping = new HashMap<Character, Character>();
        mapping.put(')', '(');
        mapping.put(']', '[');
        mapping.put('}', '{');

    }

    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (mapping.containsKey(s.charAt(i))) {
                Character tmp = stack.isEmpty() ? '#' : stack.pop();
                if (mapping.get(s.charAt(i)) != tmp) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
