package com.unisound.test;

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

/*
 * 、在开始排序前，扫描对应的存储空间（使用邻接表），将入度为 0 的结点放入队列。

2、只要队列非空，就从队首取出入度为 0 的结点，将这个结点输出到结果集中，
并且将这个结点的所有邻接结点（它指向的结点）的入度减 1，在减 1 以后，如果这个被减 1 的结点的入度为 0 ，就继续入队。

3、当队列为空的时候，检查结果集中的顶点个数是否和课程数相等即可。

 */
public class FindOrder
{
    public int[] findOrderBfs(int numCourses, int[][] prerequisites)
    {
        if (numCourses < 0) {
            return new int[0];
        }

        HashSet<Integer>[] adj = new HashSet[numCourses];

        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<Integer>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            ++indegree[prerequisites[i][0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            Integer head = queue.poll();

            res[count] = head;
            count++;

            Set<Integer> next = adj[head];

            for (int item : next) {
                indegree[item]--;
                if (indegree[item] == 0) {
                    queue.offer(item);
                }
            }
        }

        if (numCourses == count) {
            return res;
        }

        return new int[0];
    }

}
