package com.unisound.algorithm;

//一个圆，被分成N个部分，用M种颜色给每个部分上色，要求相邻区域颜色不能相同。有多少种上色方案？
public class Color
{
    public static int color(int N, int M)
    {
        int kind_new = 0;
        if (N == 1 && M >= 1)
            return M;
        if (N == 2 && M >= 2)
            return M * (M - 1);
        if (N == 3 && M >= 3)
            return M * (M - 1) * (M - 2);
        if (N > 3 && M >= 2) {
            kind_new = color(N - 1, M) * (M - 2) + color(N - 2, M) * (M - 1);// 迭代 分两种情况 求和
        }
        return kind_new;
    }

    private static int helper(int N, int M)
    {
        if (N == 0)
            return M;
        return M * (int) Math.pow(M - 1, N - 1) - helper(N - 1, M);
    }

    public static void main(String[] args)
    {
        System.out.println(color(6, 5));
        System.out.println(helper(6, 5));

    }
}
