package GeeksForGeeks.CountTheNumberOfWaysTileTheFloor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
            int m = scanner.nextInt();
            System.out.println(numberOfWaysToTileTheFloor(n, m));
        }
    }

    public static long numberOfWaysToTileTheFloor(int n, int m) {
        if (n < m) return 1;
        if (n == m) return 2;

        long mod = (long) (1e9 + 7);

        long[] dp = new long[n + 1];
        Arrays.fill(dp, 1);
        dp[m] = 2;
        dp[0] = 0;

        for (int i = m + 1; i <= n; i++) {
            dp[i] = ((dp[i - 1] % mod) + (dp[i - m] % mod)) % mod;
        }
        return dp[n];
    }

}
