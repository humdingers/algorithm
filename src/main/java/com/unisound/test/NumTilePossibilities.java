package com.unisound.test;

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
    int cnt = 0;

    public int numTilePossibilities(String tiles)
    {
        int n = tiles.length();

        char[] arr = tiles.toCharArray();

        Arrays.sort(arr);

        boolean[] used = new boolean[n];

        backpack(arr, used, 0);

        return cnt;

    }

    public void backpack(char[] arr, boolean[] used, int start)
    {

        if (start >= arr.length) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                continue;
            }
            cnt += 1;
            used[i] = true;
            backpack(arr, used, start + 1);
            used[i] = false;
        }

    }

}
