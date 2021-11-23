package LeetCode.DeapthFirstSearch.NumberOfIsland;

public class Main {

    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {

        int numberOfIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    backTrack(grid, i, j);
                    numberOfIsland++;
                }
            }
        }

        return numberOfIsland;
    }

    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void backTrack(char[][] grid, int row, int col) {

        if (!isValid(grid, row, col) || grid[row][col] == '0') return;

        grid[row][col] = '0';

        for (int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            backTrack(grid, r, c);
        }

    }

    public static boolean isValid(char[][] grid, int row, int col) {
        return (row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length);
    }

}
