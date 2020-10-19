package GoogleKickStart2020.RoundG.MaixmumCoins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFSSolution {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {

        FastReader fr = new FastReader();

        int testCase = fr.nextInt();

        for (int tt = 1; tt <= testCase; tt++) {
            int n = fr.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = fr.nextInt();
                }
            }
            solution(grid, tt);
        }
    }

    public static void solution(int[][] grid, int testCase) {

        long maximumCoins = 0;
        int n = grid.length;

        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    maximumCoins = Math.max(maximumCoins, breadthFirstSearch(grid, i, j, visited));
                }
            }
        }
        System.out.println("Case #" + testCase + ": " + maximumCoins);
    }


    public static long breadthFirstSearch(int[][] grid, int row, int col, boolean[][] visited) {
        long maxProfit = 0;
        visited[row][col] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] parent = queue.poll();
            maxProfit += grid[parent[0]][parent[1]];
            for (int[] dir : directions) {
                int r = dir[0] + parent[0];
                int c = dir[1] + parent[1];
                if (isValid(grid, r, c) && !visited[r][c]) {
                    visited[r][c] = true;
                    queue.add(new int[]{r, c});
                }
            }
        }

        return maxProfit;
    }

    public static int[][] directions = {{-1, -1}, {1, 1}};

    public static boolean isValid(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

}
