package LeetCode.DeapthFirstSearch.SurroundedRegions;

public class Main {

    public static void main(String[] args) {
        String str = "[[\"X\",\"O\",\"X\"],[\"O\",\"X\",\"O\"],[\"X\",\"O\",\"X\"]]";
        str = str.replace("[", "{");
        str = str.replace("]", "}");
        str = str.replace("\"", "\'");
    }

    public static void solve(char[][] board) {

        if(board.length == 0) return;

        int r = board.length;
        int c = board[0].length;

        for (int i = 0; i < r; i++) {
            if (board[i][0] == 'O') {
                depthFirstSearch(board, i, 0);
            }
            if (board[i][c - 1] == 'O') {
                depthFirstSearch(board, i, c - 1);
            }
        }

        for (int i = 0; i < c; i++) {
            if (board[0][i] == 'O') {
                depthFirstSearch(board, 0, i);
            }
            if (board[r - 1][i] == 'O') {
                depthFirstSearch(board, r - 1, i);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == '1') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }

    }

    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void depthFirstSearch(char[][] board, int row, int col) {
        if (!isValid(board, row, col) || board[row][col] == 'X' || board[row][col] == '1') return;
        board[row][col] = '1';
        for (int[] dir : directions) {
            depthFirstSearch(board, row + dir[0], col + dir[1]);
        }
    }

    public static boolean isValid(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

}
