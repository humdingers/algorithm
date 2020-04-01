package com.unisound.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Zconvert
{
    public String convert(String s, int numRows)
    {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> tmp = new ArrayList<StringBuilder>();

        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            tmp.add(new StringBuilder());
        }

        boolean goDown = false;
        int curRow = 0;
        for (char c : s.toCharArray()) {
            tmp.get(curRow).append(c);

            if (curRow == 0 || curRow == numRows - 1)
                goDown = !goDown;

            curRow += goDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();

        for (StringBuilder item : tmp) {
            res.append(item);
        }

        return res.toString();
    }

}
