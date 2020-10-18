package UvaOnlineJudge.Dancing_The_Cheeky_cheeky_11452;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        for (int i = 0; i < testCase; i++) {
            String text = fr.next();
            System.out.print(phiTable(text));
        }
    }

    public static String phiTable(String str) {

        StringBuilder solution = new StringBuilder();

        int[] phi = new int[str.length()];
        int i = 0, j = 1;

        while (j < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                phi[j] = i + 1;
                i++;
                j++;
            } else {
                if (i > 0) {
                    i = phi[i - 1];
                } else j++;
            }
        }

        int n = str.length() - phi[str.length() - 1];
        int s = str.length() % n;

        for (int l = s, counter = 0; counter < 8; counter++, l++) {
            if (l >= str.length()) l = 0;
            solution.append(str.charAt(l));
        }

        solution.append("...\n");

        return solution.toString();
    }
}
