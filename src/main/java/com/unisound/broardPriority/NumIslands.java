package com.unisound.broardPriority;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 200. 岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

    此外，你
 */
//时间复杂度：O(MN)
//空间复杂度：O(MN)
public class NumIslands
{
    public int numIslandsDFS(char[][] grid)
    {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int r = grid.length;
        int c = grid[0].length;

        int num_islands = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 如果是岛屿中的一个点，并且没有被访问过
                // 就进行深度优先遍
                if (grid[i][j] == '1') {
                    num_islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return num_islands;

    }

    // 空间复杂度：O(\min(M, N))
    public void dfs(char[][] grid, int r, int c)
    {
        int nr = grid.length;
        int nc = grid[0].length;

        // 如果不越界、没有被访问过、并且还要是陆地
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        // 访问过就置为0
        grid[r][c] = '0';
        // 四个方向遍历
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);

    }

    public int numIslandsBFS(char[][] grid)
    {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int r = grid.length;
        int c = grid[0].length;

        int num_islands = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    num_islands++;
                    bfs(grid, i, j);
                }
            }
        }

        return num_islands;

    }

    private void bfs(char[][] grid, int i, int j)
    {
        Queue<int[]> queue = new LinkedList<int[]>();

        int nr = grid.length;
        int nc = grid[0].length;

        queue.offer(new int[] {i, j});

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];

            if (x < 0 || y < 0 || x >= nr || y >= nc || grid[x][y] == '0') {
                continue;
            }
            grid[x][y] = '0';

            queue.offer(new int[] {x + 1, y});
            queue.offer(new int[] {x, y + 1});
            queue.offer(new int[] {x - 1, y});
            queue.offer(new int[] {x, y - 1});

        }

    }

}
