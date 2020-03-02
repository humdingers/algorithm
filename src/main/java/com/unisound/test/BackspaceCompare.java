package com.unisound.test;

public class BackspaceCompare
{ // 重构字符串
    public boolean backspaceCompare(String S, String T)
    {
        int i = S.length() - 1;
        int j = T.length() - 1;

        int skpi = 0;
        int skpj = 0;

        while (i >= 0 && j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skpi++;
                    i--;
                } else if (skpi > 0) {
                    skpi--;
                    i--;
                } else {
                    break;
                }
            }
        }
    }

}
