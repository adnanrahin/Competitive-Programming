package GoogleKickStart.KickStart2020.RoundA.Allocation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

            int size = scanner.nextInt();
            int budget = scanner.nextInt();

            int[] nums = new int[size];

            for (int i = 0; i < nums.length; i++) {
                nums[i] = scanner.nextInt();
            }

            Arrays.sort(nums);
            int sum = 0;
            int counter = 0;

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum <= budget) counter++;
            }
            System.out.println("Case #" + (++l) + ": " + counter);
        }
    }

}
