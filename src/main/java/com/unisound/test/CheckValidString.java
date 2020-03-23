package com.unisound.test;

//有效的括号字符串
/*
* 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：

      任何左括号 ( 必须有相应的右括号 )。
      任何右括号 ) 必须有相应的左括号 ( 。
      左括号 ( 必须在对应的右括号之前 )。
      * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
      一个空字符串也被视为有效字符串。
      示例 1:
      
      输入: "()"
      输出: True
      示例 2:
      
      输入: "(*)"
      输出: True
*/
public class CheckValidString
{

    public boolean checkValidString(String s)
    {
        int L = 0;
        int R = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                L++;
                R++;
            } else if (c == ')') {
                if (L > 0) {
                    L--;
                }

                if (R > 0) {
                    R--;
                } else {
                    return false;
                }
            } else if (c == '*') {
                if (L > 0) {
                    L--;
                }
                R++;

            }
        }

        return L <= 0 && R >= 0;
    }

}
