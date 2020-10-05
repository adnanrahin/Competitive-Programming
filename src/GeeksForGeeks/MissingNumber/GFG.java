package GeeksForGeeks.MissingNumber;

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
            int size = scanner.nextInt();
            int[] nums = new int[size - 1];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(MissingNumber.missing(nums, size));
        }

    }

    public static class MissingNumber {
        public static int missing(int[] nums, int n) {
            int total = (n * (n + 1)) / 2;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return total - sum;
        }
    }


}
