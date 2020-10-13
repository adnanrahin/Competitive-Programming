package UvaOnlineJudge.Modex_1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

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

    public static void main(String[] ags) {
        FastReader fr = new FastReader();
        int testCase = fr.nextInt();
        for (int i = 0; i <= testCase; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            int n = fr.nextInt();
            binaryExponential(x, y, n);
        }
    }

    public static void binaryExponential(int x, int y, int n) {
        int result = 1;
        while (y > 0) {
            if (y % 2 == 1) result = (result % n) * x;
            x *= x;
            y /= 2;
        }
        System.out.println(result % n);
    }

}
