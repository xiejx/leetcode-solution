package com.example.problem5xx;

/**
 * @author xiejx
 * @date 2024/2/1 21:02
 */
public class Solution529 {
    private int[][] directions = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        char ch = board[row][col];
        if (ch == 'M') {
            board[row][col] = 'X';
            return board;
        }
        int count = 0;
        for (int[] direction: directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

        }
        return board;
    }
}
