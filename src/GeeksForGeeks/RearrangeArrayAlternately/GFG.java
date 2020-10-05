package GeeksForGeeks.RearrangeArrayAlternately;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        optimizedSolution(new int[]{
                13, 20, 32, 35, 61, 95, 98, 118, 125, 150, 194, 220, 227, 229, 246, 271, 281, 287, 302, 307,
                318, 341, 351, 354, 369, 379, 380, 400, 404, 435, 441, 442, 445, 452, 468, 482, 489, 493, 498,
                501, 504, 529, 540, 556, 568, 571, 587, 602, 619, 620, 625, 652, 653, 676, 677, 684, 690, 709,
                710, 716, 724, 730, 733, 740, 755, 757, 765, 772, 796, 797, 830, 842, 847, 857, 866, 872, 903,
                922, 928, 933, 966
        });

        optimizedSolution(new int[]{1, 2, 3, 4, 5});

        FastReader scanner = new FastReader();

        int testCase = scanner.nextInt();

        while (testCase-- > 0) {
            int size = scanner.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            solution(arr);
            System.out.println();
        }
    }

    public static void optimizedSolution(int[] nums) {

        int mod = nums[nums.length - 1] + 1;
        int i = 0, j = nums.length - 1;

        for (int l = 0; l < nums.length; l++) {
            if (l % 2 == 0) {
                nums[l] = nums[l] + (nums[j--] % mod) * mod;
            } else {
                nums[l] = nums[l] + (nums[i++] % mod) * mod;
            }
        }

        for (int l = 0; l < nums.length; l++) {
            nums[l] /= mod;
        }
        System.out.println(Arrays.toString(nums));
    }


    public static void solution(int[] nums) {   //Two Pointer Extra Space Solution Time Complexity O(N), Space O(N)

        int[] arr = new int[nums.length];

        int i = 0, j = nums.length - 1, counter = 0;

        while (i <= j) {
            arr[counter++] = nums[j--];
            if (counter == nums.length) break;
            arr[counter++] = nums[i++];
        }

        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void solution2(int[] nums) { // BruteForce Solution O(N^2), Space(1)

        int n = nums.length;
        int temp = 1;
        for (int i = 0; i < n / 2; i++) {
            int val = nums[n - 1];

            for (int j = n - 1; j >= temp; j--) {
                nums[j] = nums[j - 1];
            }
            nums[temp - 1] = val;
            temp += 2;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

}
