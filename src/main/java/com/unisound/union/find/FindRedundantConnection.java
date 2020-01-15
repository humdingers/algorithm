package com.unisound.union.find;
//冗余链接

/*
 * 在本问题中, 树指的是一个连通且无环的无向图。

    输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
    
    结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
    
    返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
    
    示例 1：
    
    输入: [[1,2], [1,3], [2,3]]
    输出: [2,3]
    解释: 给定的无向图为:
      1
     / \
    2 - 3
    示例 2：
    
    输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
    输出: [1,4]
    解释: 给定的无向图为:
    5 - 1 - 2
        |   |
        4 - 3
 */
public class FindRedundantConnection
{
    private int count;

    private int[] parent;

    private int[] size;

    public FindRedundantConnection(int n)
    {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

    }

    private void union(int p, int q)
    {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;

    }

    private int find(int x)
    {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;

    }

    private boolean connected(int p, int q)
    {
        int rootP = find(p);
        int rootQ = find(q);

        return rootP == rootQ;

    }

    public int[] findRedundantConnection(int[][] edges)
    {
        int[] res = new int[2];
        FindRedundantConnection unionFind = new FindRedundantConnection(edges.length);

        unionFind.union(edges[0][0], edges[0][1]);
        for (int i = 1; i < edges.length; i++) {
            if (connected(edges[i][0], edges[i][1])) {
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            } else {
                unionFind.union(edges[i][0], edges[i][1]);
            }
        }
        return res;

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
