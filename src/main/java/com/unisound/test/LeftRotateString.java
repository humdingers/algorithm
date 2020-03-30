package com.unisound.test;

//左旋转字符串
/*
* 汇编语言中有一种移位指令叫做循环左移（ROL），
* 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
* 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
* 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
* 即“XYZdefabc”。是不是很简单？OK，搞定它！
*/
public class LeftRotateString
{
    public String reverseLeftWords(String str, int n)
    {
        int k = n % str.length();

        char[] arr = str.toCharArray();
        reverse(arr, 0, str.length() - 1);
        reverse(arr, 0, str.length() - k - 1);
        reverse(arr, str.length() - k, str.length() - 1);

        return new String(arr);

    }

    public void reverse(char[] arr, int left, int right)
    {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
