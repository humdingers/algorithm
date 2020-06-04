package com.unisound.greedy;

import java.util.LinkedList;

/*
 * 402. 移掉K位数字
    给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
    
    注意:
    
    num 的长度小于 10002 且 ≥ k。
    num 不会包含任何前导零。
    示例 1 :
    
    输入: num = "1432219", k = 3
    输出: "1219"
    解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
    示例 2 :
    
    输入: num = "10200", k = 1
    输出: "200"
    解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
    示例 3 :
    
    输入: num = "10", k = 2
    输出: "0"
    解释: 从原数字移除所有的数字，剩余为空就是0。
 */
/*
 * 时间复杂度：O(N)。尽管存在嵌套循环，但内部循环最多只能运行 k 次。由于 0<k≤N，
 * 主循环的时间复杂度被限制在 2N 以内。对于主循环之外的逻辑，它们的时间复杂度是 O(N)。总时间复杂度为O(N)。
空间复杂度：O(N)，在最坏的情况下栈存储了所有的数字。
 */
public class RemoveKdigits
{
    public String removeKdigits(String num, int k)
    {
        LinkedList<Character> stack = new LinkedList<Character>();

        // 贪心算法，从左往右找到第一个大于其后面数字的数字的位置，然后移除它。
        for (char digits : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && stack.peekLast() > digits) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digits);

        }

        // k没用完，从后面删除，后面的数字相对前面的大
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }

        StringBuilder res = new StringBuilder();
        boolean flag = false;

        // 删除开头是0
        for (char digit : stack) {
            if (digit != '0') {
                flag = true;
            }

            if (flag) {
                res.append(digit);
            }
        }

        if (res.length() == 0) {
            return "0";
        }

        return res.toString();

    }

    public static void main(String[] args)
    {

    }

}
