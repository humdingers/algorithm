package com.unisound.test;

import java.util.LinkedList;

/*
 * 32. 最长有效括号
    给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
    
    示例 1:
    
    输入: "(()"
    输出: 2
    解释: 最长有效括号子串为 "()"
    示例 2:
    
    输入: ")()())"
    输出: 4
    解释: 最长有效括号子串为 "()()"
 */
public class LongestValidParentheses
{
    public int longestValidParentheses(String s)
    {

        int max = 0;

        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;

    }

    public int longestValidParentheses1(String s)
    {

        int maxlength = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return maxlength;

    }

}
