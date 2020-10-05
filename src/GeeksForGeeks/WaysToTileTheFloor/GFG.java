package GeeksForGeeks.WaysToTileTheFloor;

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
            int N = scanner.nextInt();
            System.out.println(numberOfWays(N));
        }

    }

    static Long numberOfWays(int N) {
        if (N < 2) return (long) 1;
        long[] dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        long mod = (long) 1e9 + 7;
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] % mod) + (dp[i - 2] % mod);
        }
        return dp[N] % mod;
    }
}
