package com.unisound.algorithm;

public class SearchWord
{

    private boolean[][] marked;

    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    private int m;

    private int n;

    private String word;

    private char[][] board;

    public boolean exit(char[][] board, String word)
    {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        this.marked = new boolean[m][n];
        this.word = word;
        this.board = board;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start)
    {
        if (start == this.word.length() - 1) {
            return board[i][j] == this.word.charAt(start);
        }
        if (board[i][j] == this.word.charAt(start)) {
            this.marked[i][j] = true;

            for (int k = 0; k < direction.length; k++) {
                int new_x = i + direction[k][0];
                int new_y = j + direction[k][1];
                if (isArea(new_x, new_y) && !this.marked[new_x][new_y]) {
                    if (dfs(new_x, new_y, start + 1)) {
                        return true;
                    }
                }
            }

            this.marked[i][j] = false;
        }
        return false;

    }

    public boolean isArea(int x, int y)
    {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
