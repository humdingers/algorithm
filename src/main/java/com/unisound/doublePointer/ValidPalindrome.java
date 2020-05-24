package com.unisound.doublePointer;

/*
 * 680. 验证回文字符串 Ⅱ
    给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
    
    示例 1:
    
    输入: "aba"
    输出: True
    示例 2:
    
    输入: "abca"
    输出: True
    解释: 你可以删除c字符
 */
public class ValidPalindrome
{
    public boolean validPalindrome(String s)
    {
        return search(s, 0, s.length() - 1, 1);

    }

    public boolean search(String s, int left, int right, int count)
    {
        if (left > right) {
            return true;
        }

        if (s.charAt(left) == (s.charAt(right))) {
            return search(s, left + 1, right - 1, count);
        } else {
            if (count == 0) {
                return false;
            }
            return search(s, left, right - 1, count - 1) || search(s, left + 1, right, count - 1);
        }

    }

    public boolean validPalindrome1(String s)
    {
        // 如果字符串为空或者长度为1，直接返回true
        if ("".equals(s) || 1 == s.length()) {
            return false;
        }
        // 初始化指针
        int left = 0;
        int right = s.length() - 1;
        // 初始化删除标记位
        int flag = 0;

        while (left < right) {
            // 对称位置相等，循环继续
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }

            // 对称位置不等，判断标记位，为0代表尚未使用过删除功能，则继续
            if (flag == 0) {
                // 如果左右只差一位，则删除任意一个皆可，返回true
                if (left + 1 == right) {
                    return true;
                }

                // 这里需要多看一步，否则会将如"bcaacab"判断为false，错误示例如下
                // step1: b == b , continue;
                // step2: c != a , flag == 0 , a == a, flag ++, continue;
                // step3：a != c , flag == 1 , return false.
                if (s.charAt(left + 1) == s.charAt(right) && s.charAt(left + 2) == s.charAt(right - 1)) {
                    left += 2;
                    right--;
                    flag++;
                    continue;
                }
                // 此处与上处类似，不再赘述
                if (s.charAt(left) == s.charAt(right - 1) && s.charAt(left + 1) == s.charAt(right - 2)) {
                    left++;
                    right -= 2;
                    flag++;
                    continue;
                }
            }
            return false;
        }
        return true;
    }

}
