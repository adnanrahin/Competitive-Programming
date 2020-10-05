package GeeksForGeeks.ZeroOneKanpSack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GFG {

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

        FastReader scanner = new FastReader();

        int testCase = scanner.nextInt();

        while (testCase-- > 0) {
            int n = scanner.nextInt();
            int w = scanner.nextInt();
            int[] wt = new int[n];
            int[] v = new int[n];

            for (int i = 0; i < n; i++) {
                wt[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                v[i] = scanner.nextInt();
            }
            System.out.println(knapSack(n, w, wt, v));
        }
    }

    public static int knapSack(int n, int w, int[] wt, int[] v) {
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], v[i - 1] + dp[i - 1][j - wt[i - 1]]);
                } else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][w];
    }

}
