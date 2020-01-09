package com.unisound.algorithm;

//回文数
/*
 * 只反转 \text{int}int 数字的一半？毕竟，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
    
    例如，输入 1221，我们可以将数字 “1221” 的后半部分从 “21” 反转为 “12”，
    并将其与前半部分 “12” 进行比较，因为二者相同，我们得知数字 1221 是回文。

 */
public class palindromeNum
{
    public static boolean isPalindrome(int num)
    {
        if (num < 0 || num % 10 == 0 && num != 0) {
            return false;
        }

        int revertedNumber = 0;
        while (num > revertedNumber) {
            revertedNumber = revertedNumber * 10 + num % 10;
            num /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除

        return num == revertedNumber || num == revertedNumber / 10;
    }

    public static void main(String[] args)
    {
        System.out.println(isPalindrome(3113));

    }

}
