package com.unisound.test;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 1162. 地图分析
        你现在手里有一份大小为 N x N 的「地图」（网格） grid，上面的每个「区域」（单元格）都用 0 和 1 标记好了。
        其中 0 代表海洋，1 代表陆地，请你找出一个海洋区域，这个海洋区域到离它最近的陆地区域的距离是最大的。
        
        我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
        
        如果我们的地图上只有陆地或者海洋，请返回 -1。
        
         
        
        示例 1：
        
        
        
        输入：[[1,0,1],[0,0,0],[1,0,1]]
        输出：2
        解释： 
        海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 */
//O(n2)
//BFS 完全可以以多个格子同时作为起点。我们可以把所有的陆地格子同时放入初始队列，然后开始层序遍历，这样遍历的效果如下图所示
public class MaxDistance
{
    public int maxDistance(int[][] grid)
    {
        int n = grid.length;

        Queue<int[]> queue = new LinkedList<int[]>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }

            }
        }

        if (queue.isEmpty() || queue.size() == n * n) {
            return -1;
        }

        int distance = 0;

        int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
        while (!queue.isEmpty()) {

            int m = queue.size();

            ++distance;

            for (int i = 0; i < m; i++) {
                int[] head = queue.poll();
                int x = head[0];
                int y = head[1];

                for (int[] dir : dirs) {
                    int newx = x + dir[0];
                    int newy = y + dir[1];

                    if (isArea(grid, newx, newy) && grid[newx][newy] == 0) {
                        grid[newx][newy] = 2;
                        queue.offer(new int[] {newx, newy});
                    }

                }
            }

        }
        // 由于最后一步，没有可以扩散的的区域，但是 step 加了 1，故在退出循环的时候应该减 1

        return distance - 1;

    }

    public boolean isArea(int[][] grid, int x, int y)
    {
        if (x >= 0 && y >= 0 && x < grid.length && y < grid.length) {
            return true;
        }
        return false;
    }

}
