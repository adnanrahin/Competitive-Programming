package UvaOnlineJudge.LeadingAndTrailing_11029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

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

        for (int i = 1; i <= testCase; i++) {
            long n = fr.nextInt();
            long k = fr.nextInt();
            solution(n, k);
        }
    }

    public static void solution(long n, long k) {

        double d = Math.log10(n) * k;
        int leading = (int) (Math.pow(10, (d - (int) d)) * 100);

        long res = 1;
        while (k > 0) {
            if (k % 2 == 1) res = (res % 1000) * (n % 1000);
            n = (n % 1000) * (n % 1000);
            k /= 2;
        }
        res %= 1000;
        System.out.printf("%03d...%03d\n", leading, res);
    }
}
