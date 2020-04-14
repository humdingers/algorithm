package com.unisound.test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。

    现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
    
     
    
    示例 1：
    
    输入: 
    n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
    src = 0, dst = 2, k = 1
    输出: 200
    解释: 
    城市航班图如下
    
    
    从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。

 */

/*
 * 寻找源到目标的最低花费，Dijkstra 是一个好的算法。

    Dijstra 算法的基本思想就是：按照 cost 从小到大的顺序扩展所有可能的飞行路线，当城市被添加到 dst 时，dst 中对应的值就是到达该城市的最低花费。
    
    算法
    
    在 Dijkstra 算法中，借助优先级队列持续搜索花费最低的下一个城市。
    
    如果查找到某个城市，它原本的路线成本更低或者中转次数过多，则无需再搜索它。否则，如果搜索到目的城市，那么当前花费就是最低成本，因为每次最先搜索的就是最低成本航线。
    
    否则，如果从 node 城市出发的航线花费更低，则将该节点加入到优先级队列用于搜索。

 */
//时间复杂度：O(E+nlogn)，其中 E 是航线的数量。
//未使用最小优先队列实现，其时间复杂度为 O(V2)，基于 Fibonacci heap 的最小优先队列实现版本，其时间复杂度为 O(E + VlogV)。
//Bellman-Ford 算法能适应一般的情况（即存在负权边的情况）。一个实现的很好的 Dijkstra 算法比 Bellman-Ford 算法的运行时间 O(V*E) 要低
// V代表顶点数，E代表边数。
public class FindCheapestPrice
{
    // 将1000替换成n也可以
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
    {
        int[][] graph = new int[n][n];

        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        Map<Integer, Integer> best = new HashMap<Integer, Integer>();
        PriorityQueue<int[]> tmp = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);

        tmp.offer(new int[] {0, 0, src});

        while (!tmp.isEmpty()) {
            int[] info = tmp.poll();
            int cost = info[0];
            int k = info[1];
            int place = info[2];

            if (k > K + 1 || cost > best.getOrDefault(k * n + place, Integer.MAX_VALUE)) {
                continue;
            }

            if (place == dst) {
                return cost;
            }

            for (int nei = 0; nei < n; nei++) {
                if (graph[place][nei] > 0) {
                    int newcost = cost + graph[place][nei];
                    if (newcost < best.getOrDefault((k + 1) * n + nei, Integer.MAX_VALUE)) {
                        best.put((k + 1) * n + nei, newcost);
                        tmp.offer(new int[] {newcost, k + 1, nei});
                    }
                }
            }

        }
        return -1;

    }

}
