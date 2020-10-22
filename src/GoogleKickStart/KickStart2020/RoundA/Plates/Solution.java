package GoogleKickStart.KickStart2020.RoundA.Plates;

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

    public static void main(String[] args) {

        FastReader scanner = new FastReader();

        int testCase = scanner.nextInt();

        int l = 0;

        while (l < testCase) {
            l++;
            int t = scanner.nextInt();
            int k = scanner.nextInt();
            int p = scanner.nextInt();
            int[][] matrix = new int[t][k];
            for (int i = 0; i < t; i++) {
                for (int j = 0; j < p; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            solve(matrix, p, l);
        }
    }

    public static void solve(int[][] matrix, int p, int l) {



    }

}
