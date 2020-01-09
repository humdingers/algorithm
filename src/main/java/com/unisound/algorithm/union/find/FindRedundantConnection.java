package com.unisound.algorithm.union.find;

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
            if (unionFind.find(edges[i][0]) == unionFind.find(edges[i][1])) {
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
