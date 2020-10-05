package GeeksForGeeks.EquilibriumPoint;

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
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            solution(arr);
        }
    }

    public static void solution(int[] nums) {

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (prefix[i] == suffix[i]) {
                System.out.println(i + 1);
                return;
            }
        }

        System.out.println(-1);

    }


}
