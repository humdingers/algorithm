package com.unisound.union.find;

public class FindCircleNum
{
    private int count;

    private int[] parent;

    private int[] size;

    public FindCircleNum(int n)
    {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

    }

    public void union(int p, int q)
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

    public boolean connected(int p, int q)
    {
        int rootP = find(p);
        int rootQ = find(q);

        return rootP == rootQ;

    }

    public int findCircleNum(int[][] M)
    {
        FindCircleNum unionFind = new FindCircleNum(M.length);

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count;

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
