package com.unisound.test;

import java.util.ArrayList;
import java.util.List;

//6. Z 字形变换
/*
* 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
*/
public class Zconvert
{
    public String convert(String s, int numRows)
    {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> tmp = new ArrayList<StringBuilder>();

        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            tmp.add(new StringBuilder());
        }

        boolean goDown = false;
        int curRows = 0;

        for (char c : s.toCharArray()) {
            tmp.get(curRows).append(c);

            if (curRows == 0 || curRows == numRows - 1) {
                goDown = !goDown;
            }

            curRows += goDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder item : tmp) {
            res.append(item);
        }

        return res.toString();
    }

}
