package com.unisound.test;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 542. 01 矩阵
    给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
    
    两个相邻元素间的距离为 1 。
    
    示例 1:
    输入:
    
    0 0 0
    0 1 0
    0 0 0
    输出:
    
    0 0 0
    0 1 0
    0 0 0
    示例 2:
    输入:
    
    0 0 0
    0 1 0
    1 1 1
    输出:
    
    0 0 0
    0 1 0
    1 2 1
 */
//多源Bfs
/*
 * 首先把每个源点 0 入队，然后从各个 0 同时开始一圈一圈的向 1 扩散
 * （每个 1都是被离它最近的 0 扩散到的 ），扩散的时候可以设置 int[][] dist 来记录距离（即扩散的层次）
 * 并同时标志是否访问过。对于本题是可以直接修改原数组 int[][] matrix 来记录距离和标志是否访问的,
 * 这里要注意先把 matrix 数组中 1 的位置设置成 -1 （设成Integer.MAX_VALUE啦，m * n啦，10000啦都行，
 * 只要是个无效的距离值来标志这个位置的 1 没有被访问过就行辣~）
复杂度分析：

每个点入队出队一次，所以时间复杂度：O(n * m)
 */
/*
 * dp[i][j]含义：就像题目中要求的matrix[i][j]距离0的最小距离。

初始化：dp数组元素赋一个最大值，遍历矩阵元素为0的地方先填写完毕。

状态转移：第一次遍历从左上到右下填表，每次只向右向下"搜索"；第二次遍历从右下到左上填表，每次只向左向上"搜索"。

 */
public class UpdateMatrix
{
    public int[][] updateMatrix(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0) {
            return null;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        boolean[][] visited = new boolean[row][col];

        Queue<int[]> queue = new LinkedList<int[]>();

        int res[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    visited[i][j] = true;
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            int x = head[0];
            int y = head[1];

            for (int[] dir : dirs) {
                int newx = x + dir[0];
                int newy = y + dir[1];

                if (isArea(matrix, newx, newy) && !visited[newx][newy]) {
                    res[x][y] += 1;
                    visited[newx][newy] = true;
                    queue.offer(new int[] {newx, newy});

                }
            }

        }
        return res;

    }

    // 判断是否越界
    boolean isArea(int[][] matrix, int r, int c)
    {
        return (r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length);
    }

}
