package com.unisound.backpack;

//矩阵中的路径

/*
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 
   矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class HasPath
{
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[] flag = new boolean[matrix.length];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (judge(matrix, i, j, rows, cols, flag, str, 0)) {
                    return true;
                }

            }
        }

        return false;

    }

    // judge(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，待判断的字符串，字符串索引初始为0即先判断字符串的第一位)
    private boolean judge(char[] matrix, int i, int j, int rows, int cols, boolean[] flag, char[] str, int k)
    {
        int index = i * cols + j;
        // 递归终止条件
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || flag[index] == true)
            return false;
        // 若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if (k == str.length - 1)
            return true;
        // 要走的第一个位置置为true，表示已经走过了
        flag[index] = true;

        // 回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if (judge(matrix, i - 1, j, rows, cols, flag, str, k + 1)
            || judge(matrix, i + 1, j, rows, cols, flag, str, k + 1)
            || judge(matrix, i, j - 1, rows, cols, flag, str, k + 1)
            || judge(matrix, i, j + 1, rows, cols, flag, str, k + 1)) {
            return true;
        }
        flag[index] = false;
        return false;

    }

}
