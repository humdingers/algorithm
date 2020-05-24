package com.unisound.backpack;

import java.util.Arrays;

/*
 * 1079. 活字印刷
    你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
    
    注意：本题中，每个活字字模只能使用一次。
    
     
    
    示例 1：
    
    输入："AAB"
    输出：8
    解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
    
 */
public class NumTilePossibilities
{
    int cnt;

    public int numTilePossibilities(String tiles)
    {
        int n = tiles.length();

        char[] charArray = tiles.toCharArray();

        Arrays.sort(charArray);
        cnt = 0;

        boolean[] used = new boolean[n];

        backpack(charArray, 0, used);
        return cnt;
    }

    public void backpack(char[] charArray, int start, boolean[] used)
    {
        if (start >= charArray.length) {
            return;
        }

        // 对应子集和有重复元素的全排列，其实是子集的全排列
        for (int i = 0; i < charArray.length; i++) {
            if (!used[i]) {
                if (i > 0 && charArray[i] == charArray[i - 1] && !used[i - 1]) {
                    continue;
                }
                cnt++;
                used[i] = true;
                backpack(charArray, start + 1, used);
                used[i] = false;
            }
        }
    }

}
