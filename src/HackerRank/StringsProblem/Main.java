package HackerRank.StringsProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
            int steps = fr.nextInt();
            String str = fr.next();

            System.out.println(countingValleys(steps, str));

        }
    }

    public static int countingValleys(int steps, String path) {
        int counter = 0;
        int numberOfValley = 0;
        int[] dp = new int[steps + 1];
        for (int i = 1; i <= steps; i++) {
            if (path.charAt(i - 1) == 'U') dp[i] = dp[i - 1] + 1;
            else if (path.charAt(i - 1) == 'D') dp[i] = dp[i - 1] - 1;
        }

        for (int i = 1; i <= steps; i++) {
            if (dp[i] == 0 && dp[i - 1] == -1) {
                numberOfValley++;
            }
        }

        return numberOfValley;
    }


    /*
    *
    * 12
        DDUUDDUDUUUD
    * */

}
