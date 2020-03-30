package com.unisound.test;

//着色问题
//一个圆，被分成N个部分，用M种颜色给每个部分上色，要求相邻区域颜色不能相同。有多少种上色方案？
/*
* N,M 考虑两种情况，新加的第N块扇形的颜色跟旁边两块相关，
  
  1.  如果旁边两块颜色不同 那么是color(N-1,M)，那么第N块有M-2种颜色，有color(N-1,M)*（M-2）种可能；
  
  2.  如果旁边两块颜色相同 那么是color(N-2,M)（相当于可以随便去掉第N块旁边的一块不影响讨论），那么第N块有M-1种颜色，有color(N-2,M)*（M-1）种可能；
  
  综上，有1+2种情况。

*/

public class Color
{
    public static int color(int N, int M)
    {
        int kind_new = 0;
        if (N == 1 && M >= 1) {
            return M;
        }

        if (N == 2 && M >= 2) {
            return M * (M - 1);
        }

        if (N == 3 && M >= 3) {
            return M * (M - 1) * (M - 2);

        }

        if (N > 3 && M >= 2) {
            kind_new = color(N - 1, M) * (M - 2) + color(N - 2, M) * (M - 1);

        }

        return kind_new;

    }

}
