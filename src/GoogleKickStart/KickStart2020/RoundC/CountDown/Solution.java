package GoogleKickStart.KickStart2020.RoundC.CountDown;

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

        FastReader fr = new FastReader();

        int testCase = fr.nextInt();

        for (int tt = 1; tt <= testCase; tt++) {

            long n = fr.nextInt();
            long k = fr.nextInt();
            long[] arr = new long[(int) n];
            for (int i = 0; i < n; i++) {
                arr[i] = fr.nextInt();
            }
            solution(arr, k, tt);
        }
    }

    public static void solution(long[] arr, long k, int caseNumber) {

        long counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                long j = k;
                while (i < arr.length && j == arr[i] && j >= 1) {
                    i++;
                    j--;
                }
                if (j == 0) counter++;
                i--;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + counter);
    }

}
