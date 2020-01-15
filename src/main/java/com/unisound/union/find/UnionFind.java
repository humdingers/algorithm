package com.unisound.union.find;

public class UnionFind
{
    // 记录有多少连通分量
    private int count;

    // 父节点
    private int[] parent;

    // 记录每棵树包含的节点
    private int[] size;

    // n为图的节点总数
    public UnionFind(int n)
    {
        // 初始，互相不连通，各自为连通分量
        this.count = n;
        parent = new int[n];
        size = new int[n];
        // 初始父指针都指向自己
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

    }

    // 连通两个节点
    public void union(int p, int q)
    {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        // 小树接到大树下面，平衡性优化
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            // 两棵树合并一颗
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        // 合并后连通分量减少
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

    // 判断两个节点的连通性
    public boolean connected(int p, int q)
    {
        int rootP = find(p);
        int rootQ = find(q);

        return rootP == rootQ;

    }

    public int count()
    {
        return count;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
