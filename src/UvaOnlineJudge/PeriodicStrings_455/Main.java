package UvaOnlineJudge.PeriodicStrings_455;

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

        System.out.println(phiTable("ho0ho0ho0"));
        System.out.println(phiTable("abcabcabcabc"));

        /*FastReader fr = new FastReader();
        int testCase = fr.nextInt();
        for (int i = 0; i < testCase; i++) {
            String str = fr.nextLine();
            System.out.println(str);
        }*/
    }

    public static int phiTable(String word) {

        int[] phi = new int[word.length()];

        int i = 0, j = 1;

        while (j < word.length()) {
            if (word.charAt(i) == word.charAt(j)) {
                phi[j] = i + 1;
                i++;
                j++;
            } else {
                if (i == 0) {
                    phi[j] = 0;
                    j++;
                } else {
                    i = phi[i - 1];
                }
            }
        }

        System.out.println(Arrays.toString(phi));

        return 0;
    }

}
