package com.unisound.reverse;

//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
//例如输入字符串"I am student."，则输出"student. a am I"。

public class ReverseSentence
{
    public static void main(String[] args)
    {
        String string = "I am a student. ";

        reverseSentence(string);
    }

    private static void reverseSentence(String str)
    {
        if (str == null)
            return;
        char[] arr = str.toCharArray();

        reverse(arr, 0, arr.length - 1);
        System.out.println(new String(arr));
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                reverse(arr, start, end - 1);
                end++;
                start = end;
            } else if (i == arr.length - 1) {
                reverse(arr, start, end);
            } else {
                end++;
            }
        }

        for (char c : arr) {
            System.out.print(c);
        }
    }

    public static void reverse(char[] arr, int start, int end)
    {
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }

    }

    public String reverseWords(String s)
    {
        String[] tmp = s.trim().split(" ");

        StringBuffer tmpBuffer = new StringBuffer();

        for (int i = tmp.length - 1; i >= 0; i++) {
            if (tmp[i] == "") {
                continue;
            }

            if (i == 0) {
                tmpBuffer.append(tmp[i]);
            } else {
                tmpBuffer.append(tmp[i] + " ");
            }
        }

        return tmpBuffer.toString();
    }

}
