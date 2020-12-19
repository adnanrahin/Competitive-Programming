package LeetCode.NumberOfIslands;

public class Main {

    public static void main(String[] args) {

        char[][] board = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

    }

}

class Solution {

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {

        int row = grid.length, col = grid[0].length, numberOfIsland = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    numberOfIsland++;
                    depthFirstSearch(grid, i, j);
                }
            }
        }

        return numberOfIsland;
    }

    public void depthFirstSearch(char[][] board, int row, int col) {
        if (!isValid(board, row, col) || board[row][col] == '0') return;

        board[row][col] = '0';

        for (int[] dir : directions) {
            int r = row + dir[0], c = col + dir[1];
            depthFirstSearch(board, r, c);
        }

        return;

    }

    public boolean isValid(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

}