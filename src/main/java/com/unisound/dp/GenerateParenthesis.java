package com.unisound.dp;

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
    public List<String> generateParenthesis(int n)
    {
        if (n == 0) {
            return new ArrayList<String>();
        }
        List<List<String>> dp = new ArrayList<List<String>>();

        List<String> dp0 = new ArrayList<String>();
        dp0.add("");

        dp.add(dp0);
        for (int i = 1; i <= n; i++) {

            List<String> dpi = new ArrayList<String>();
            for (int j = 0; j < i; j++) {
                List<String> dpj = dp.get(j);
                List<String> dpi_1_j = dp.get(i - 1 - j);

                for (String str1 : dpj) {
                    for (String str2 : dpi_1_j) {

                        dpi.add('(' + str1 + ')' + str2);
                    }
                }
            }
            dp.add(dpi);

        }
        return dp.get(n);

    }

    public List<String> generateParenthesisBackPack(int n)
    {
        if (n == 0) {
            return new ArrayList<String>();
        }

        List<String> res = new ArrayList<String>();

        backpack("", n, n, res);

        return res;

    }

    // n对括号，说明左括号n，右括号n，然后
    public void backpack(String subRes, int left, int right, List<String> res)
    {
        // 结束条件
        if (left == 0 && right == 0) {
            res.add(subRes);
        } else {
            // 怎么选择放置左括号还是右括号
            // 还有剩余的左括号，那这个格子就可以放左括号
            if (left > 0) {
                backpack(subRes + '(', left - 1, right, res);
            }

            if (left < right) {
                // 只有剩余的右括号多于左括号时，这个格子才可以放右括号 ****重点理解***
                // 比如()()_ _，那第五层递归就不能放右括号，因为剩余的左右括号相等
                backpack(subRes + ')', left, right - 1, res);
            }
        }

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
