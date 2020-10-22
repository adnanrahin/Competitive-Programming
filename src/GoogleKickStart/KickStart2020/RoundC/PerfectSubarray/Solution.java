package GoogleKickStart.KickStart2020.RoundC.PerfectSubarray;

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
            int size = fr.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = fr.nextInt();
            }
            solution(arr, tt);
        }
    }

    public static void solution(int[] arr, int caseNumber) {
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                int sqrt = (int) Math.sqrt(sum);
                if (sqrt * sqrt == sum) {
                    counter++;
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + counter);
    }

}
