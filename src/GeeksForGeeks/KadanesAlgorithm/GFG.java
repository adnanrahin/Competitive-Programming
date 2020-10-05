package GeeksForGeeks.KadanesAlgorithm;

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
        FastReader s = new FastReader();
        int testCase = s.nextInt();
        int count = 0;
        while (testCase-- > 0) {
            int size = s.nextInt();
            int[] nums = new int[size];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = s.nextInt();
            }
            System.out.println(KadanesAlgorithm.maxSubArray(nums));
        }

    }

    public static class KadanesAlgorithm {

        public static int maxSubArray(int[] nums) {
            int local = nums[0];
            int maxSum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                local = Math.max(local + nums[i], nums[i]);
                maxSum = Math.max(local, maxSum);
            }
            return maxSum;
        }
    }

}
