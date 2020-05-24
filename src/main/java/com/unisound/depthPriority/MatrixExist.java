package com.unisound.depthPriority;

/*
 * 面试题12. 矩阵中的路径
    请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
    路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
    如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
    例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
    
    [["a","b","c","e"],
    ["s","f","c","s"],
    ["a","d","e","e"]]
    
    但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
    
     
    
    示例 1：
    
    输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    输出：true
 */

/*
 * 时间复杂度 O(3^KMN)： 最差情况下，需要遍历矩阵中长度为 KK 字符串的所有方案，时间复杂度为 O(3^K)；矩阵中共有 MN 个起点，时间复杂度为 O(MN) 。
方案数计算： 设字符串长度为 K ，搜索中每个字符有上、下、左、右四个方向可以选择，舍弃回头（上个字符）的方向，
剩下 3 种选择，因此方案数的复杂度为 O(3^K)
空间复杂度 O(K) ： 搜索过程中的递归深度不超过 K ，因此系统因函数调用累计使用的栈空间占用 O(K) （因为函数返回后，系统调用的栈空间会释放）。
最坏情况下 K = MNK=MN ，递归深度为 MN ，此时系统栈使用 O(MN)的额外空间。
 */

/*
 * 算法剖析：
递归参数： 当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
终止条件：
返回 falsefalse ： ① 行或列索引越界 或 ② 当前矩阵元素与目标字符不同 或 ③ 当前矩阵元素已访问过 （③ 可合并至 ② ） 。
返回 truetrue ： 字符串 word 已全部匹配，即 k = len(word) - 1 。
递推工作：
标记当前矩阵元素： 将 board[i][j] 值暂存于变量 tmp ，并修改为字符 '/' ，代表此元素已访问过，防止之后搜索时重复访问。
搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 连接 （代表只需一条可行路径） ，并记录结果至 res 。
还原当前矩阵元素： 将 tmp 暂存值还原至 board[i][j] 元素。
回溯返回值： 返回 res ，代表是否搜索到目标字符串。

 */
public class MatrixExist
{
    public boolean exist(char[][] board, String word)
    {
        int m = board.length;
        int n = board[0].length;

        char[] target = word.toCharArray();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, visited, target, i, j, 0)) {
                    return true;
                }

            }
        }

        return false;

    }

    public boolean dfs(char[][] board, boolean[][] visited, char[] target, int i, int j, int k)
    {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || visited[i][j] || board[i][j] != target[k]) {
            return false;
        }

        if (k == target.length - 1) {
            return true;
        }

        visited[i][j] = true;

        boolean res = dfs(board, visited, target, i + 1, j, k + 1) || dfs(board, visited, target, i, j + 1, k + 1)
            || dfs(board, visited, target, i - 1, j, k + 1) || dfs(board, visited, target, i, j - 1, k + 1);

        visited[i][j] = false;

        return res;
    }

}
