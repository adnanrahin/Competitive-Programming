package GeeksForGeeks.NumberOfPossibleWaysToArrangeCoin;

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

        System.out.println(count(new int[]{1, 2, 3}, 3, 4));

        FastReader scanner = new FastReader();

        int testCase = scanner.nextInt();

        while (testCase-- > 0) {

        }

    }

    public static long count(int[] coins, int m, int total) {
        long[] dp = new long[total + 1];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= total; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }

        return dp[total];
    }

}
