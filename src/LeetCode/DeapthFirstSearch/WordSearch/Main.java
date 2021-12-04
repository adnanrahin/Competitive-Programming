package LeetCode.DeapthFirstSearch.WordSearch;

public class Main {

    public static void main(String[] args) {

    }

    public static boolean exist(char[][] board, String word) {


        return true;
    }

    public static int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void dfs(char[][] board, int row, int col, String word, String look) {


    }

    public static boolean isValid(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

}
