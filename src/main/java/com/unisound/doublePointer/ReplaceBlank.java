package com.unisound.doublePointer;

//替换空格
//请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入"We are happy"，则输出"We%20are%20happy"
public class ReplaceBlank
{
    public static String replace(String s)
    {
        char[] charArray = s.toCharArray();
        int count = 0;
        for (char c : charArray) {
            if (c == ' ') {
                count += 1;
            }
        }
        if (count == 0) {
            return s;
        }
        char[] tmp = new char[s.length() + 2 * count];
        int i = s.length() - 1;
        int j = s.length() + 2 * count - 1;

        while (i >= 0) {
            if (charArray[i] == ' ') {
                tmp[j] = '0';
                tmp[j - 1] = '2';
                tmp[j - 2] = '%';

                j -= 3;

            } else {
                tmp[j] = charArray[i];
                j--;
            }

            i--;
        }

        return new String(tmp);

    }

    public static void main(String[] args)
    {
        System.out.print(replace("端到端 发发发 发11  f"));

    }

}
