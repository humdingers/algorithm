package com.unisound.broardPriority;

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
        // 将所有的陆地格子加入队列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        // 如果地图上只有陆地或者海洋，返回 -1
        if (queue.isEmpty() || queue.size() == n * n) {
            return -1;
        }

        int[][] direcs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int distance = 0; // 记录当前遍历的层数（距离） 层数就是距离

        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        while (!queue.isEmpty()) {
            distance++;
            int m = queue.size();

            for (int i = 0; i < m; i++) {
                int[] tmp = queue.poll();
                int r = tmp[0];
                int c = tmp[1];

                for (int[] direc : direcs) {
                    int new_r = r + direc[0];
                    int new_c = c + direc[1];

                    if (isArea(grid, new_r, new_c) && grid[new_r][new_c] == 0) {
                        grid[new_r][new_c] = 2;
                        queue.offer(new int[] {new_r, new_c});
                    }

                }
            }

        }

        return distance;

    }

    // 判断是否越界
    boolean isArea(int[][] grid, int r, int c)
    {
        return (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length);
    }

}
