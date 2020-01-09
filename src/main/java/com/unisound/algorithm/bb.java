package com.unisound.algorithm;

import java.util.Scanner;

public class bb
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        double[] nums = new double[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextDouble();
        }
        System.out.printf("%.2f\n", Math.floor(solve(nums, k) * 100) / 100);
    }

    public static double solve(double[] nums, int K)
    {
        double lb = 0.00, ub = 10e5 + 0.01;
        while (lb + 0.001 < ub) {
            double mid = lb + (ub - lb) / 2;
            if (C(nums, mid, K)) {
                lb = mid;
            } else {
                ub = mid;
            }
        }
        return lb;
    }

    public static boolean C(double[] nums, double seg, int k)
    {
        int count = 0;
        for (double num : nums) {
            count += Math.floor(num / seg);
        }
        return count >= k;
    }
}
