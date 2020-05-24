package com.unisound.algorithm;

/*
 * 50. Pow(x, n)
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
 */
/*
 * 直接从左到右进行推导看上去很困难，因为在每一步中，我们不知道在将上一次的结果平方之后，还需不需要额外乘 x。但如果我们从右往左看，分治的思想就十分明显了：

当我们要计算 x^n 时，我们可以先递归地计算出 y = x^{n/2}
 ，其中{n/2}表示对 n/2进行下取整；

根据递归计算的结果，如果 n 为偶数，那么 x^n = y^2
 ；如果 n 为奇数，那么 x^n = y^2 * x

递归的边界为 n = 0，任意数的 0次方均为 1。

由于每次递归都会使得指数减少一半，因此递归的层数为O(logn)，算法可以在很快的时间内得到结果。

 */
public class MyPow
{
    public double myPow(double x, int n)
    {
        int N = n;

        return N >= 0 ? quickMat(x, n) : 1 / quickMat(x, -n);

    }

    public double quickMat(double x, int n)
    {
        if (n == 0) {
            return 1.0;
        }

        double y = quickMat(x, n / 2);

        return n % 2 == 0 ? y * y : y * y * x;

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
