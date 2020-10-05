package GeeksForGeeks.SubArrayWithGivenSum;

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
            int target = scanner.nextInt();
            int[] nums = new int[size];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = scanner.nextInt();
            }
            subArraysSum(nums, target);
        }
    }

    public static void subArraysSum(int[] nums, int target) {
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            if (sum < target) {
                sum += nums[right++];
            } else if (sum > target) {
                sum -= nums[left++];
            }
            if (sum == target) {
                System.out.println((left + 1) + " " + (right));
                return;
            }
        }
        while (left < right) {
            if (sum == target) {
                System.out.println((left + 1) + " " + (right));
                return;
            }
            sum -= nums[left++];
        }
        System.out.println("-1");
    }


}
