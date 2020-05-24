package com.unisound.broardPriority;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * 210. 课程表 II
    现在你总共有 n 门课需要选，记为 0 到 n-1。
    
    在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
    
    给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
    
    可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
    
    示例 1:
    
    输入: 2, [[1,0]] 
    输出: [0,1]
    解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
    示例 2:
    
    输入: 4, [[1,0],[2,0],[3,1],[3,2]]
    输出: [0,1,2,3] or [0,2,1,3]
    解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
         因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 */
//时间复杂度：O(E + V)。这里 E 表示邻边的条数，V 表示结点的个数
//空间复杂度：O(V)
public class FindOrder
{
    public int[] findOrderBfs(int numCourses, int[][] prerequisites)
    {
        if (numCourses < 0) {
            return new int[0];
        }

        HashSet<Integer>[] adj = new HashSet[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<Integer>();
        }

        int[] inDegree = new int[numCourses];

        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int count = 0;

        while (!queue.isEmpty()) {
            // 当前入度为 0 的结点
            Integer head = queue.poll();
            res[count] = head;
            count++;

            Set<Integer> next = adj[head];

            for (Integer item : next) {
                inDegree[item]--;
                // 马上检测该结点的入度是否为 0，如果为 0，马上加入队列
                if (inDegree[item] == 0) {
                    queue.offer(item);
                }
            }

        }

        // 如果结果集中的数量不等于结点的数量，就不能完成课程任务，这一点是拓扑排序的结论

        if (count == numCourses) {
            return res;
        }

        return new int[0];

    }

    public int[] findOrderDfs(int numCourses, int[][] prerequisites)
    {

    }

}
