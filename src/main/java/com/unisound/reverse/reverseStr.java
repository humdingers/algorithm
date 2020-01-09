package com.unisound.reverse;

public class reverseStr
{
    public void reverse(char[] s)
    {
        if (null == s || s.length < 2) {
            return;
        }
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
        return;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
