package com.unisound.test;

import java.util.ArrayList;
import java.util.List;

//生成有效括号
/*
* 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
"((()))",
"(()())",
"(())()",
"()(())",
"()()()"
]

*/
public class GenerateParenthesis
{
    public List<String> generateParenthesisBackPack(int n)
    {
        List<String> res = new ArrayList<String>();
        if (n <= 0) {
            return res;
        }

        backpack("", n, n, res);

        return res;
    }

    // n对括号，说明左括号n，右括号n，然后
    public void backpack(String subRes, int left, int right, List<String> res)
    {
        if (left == 0 && right == 0) {
            res.add(subRes);
        } else {
            if (left > 0) {
                backpack(subRes + "(", left - 1, right, res);
            }

            if (left < right) {
                backpack(subRes + ")", left, right - 1, res);
            }
        }

    }
}
