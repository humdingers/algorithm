package com.unisound.dp;

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

/*
 * 时间复杂度： O(n) 。 n是给定字符串的长度。

        空间复杂度： O(n) 。栈的大小最大达到 n 。
 */
/*
 * 栈底永远保存着当前有效子串的前一个字符的下标，就像个守门员一样守在那里，所以一开始要将-1放入栈中。
2、遇到左括号就入栈；
3、遇到右括号就将栈顶元素出栈。此时有两种情况：
（1）如果栈顶元素出栈后，栈内剩下的元素不为空，则说明弹出的这个栈顶元素一定是左括号，讲真，因为栈底有保险。
（2）如果栈顶元素出栈后，栈内为空，则说明刚刚弹出的这个栈顶元素就是之前的“有效子串前一位的字符下标”，守门员都没了，所以此时应该使用当前的右括号的下标入栈，更新这个“有效子串前一位的字符下标”。
 */
public class LongestValidParentheses
{
    public int longestValidParentheses(String s)
    {
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();

        // 栈，保底、
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // 需要保底
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;

    }

    // 时间复杂度： O(n) 。遍历两遍字符串。
    // 空间复杂度： O(1)
    public int longestValidParentheses1(String s)
    {
        int left = 0;
        int right = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, right * 2);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, left * 2);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return maxLength;

    }
}
