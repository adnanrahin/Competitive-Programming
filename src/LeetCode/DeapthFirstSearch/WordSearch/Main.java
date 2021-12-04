package LeetCode.DeapthFirstSearch.WordSearch;

public class Main {

    public static void main(String[] args) {

    }

    public static boolean exist(char[][] board, String word) {

        int row = board.length, col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                boolean[][] visited = new boolean[row][col];

                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0, visited)) return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board, int row, int col, String word, int counter, boolean[][] visited) {

        if (counter == word.length()) {
            return true;
        }
        if (!isValid(board, row, col) || visited[row][col] || board[row][col] != word.charAt(counter)) {
            return false;
        }

        char temp = board[row][col];
        visited[row][col] = true;

        for (int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (dfs(board, r, c, word, counter + 1, visited)) return true;
        }

        board[row][col] = temp;
        visited[row][col] = false;

        return false;
    }

    static int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static boolean isValid(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

}
