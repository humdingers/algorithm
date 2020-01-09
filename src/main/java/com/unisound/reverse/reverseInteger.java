package com.unisound.reverse;

public class reverseInteger
{

    public int reverse(int num)
    {
        int rev = 0;
        while (num != 0) {
            int pop = num % 10;
            num /= 10;

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;

    }

    public static void main(String[] args)
    {
        long l = 42;
        int i = (int) l;
        System.out.print(i);

    }
}
