package GoogleKickStart.KickStart2016.RoundA.CountryLeader;

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
            int numberOfNames = fr.nextInt();
            String name = "";
            int counter = 0;
            for (int i = 0; i < numberOfNames; i++) {
                String newString = fr.nextLine();
                int temp = solution(newString);
                if (counter < temp) {
                    counter = temp;
                    name = newString;
                } else if (temp == counter) {
                    if (name.compareTo(newString) > 0) {
                        name = newString;
                    }
                }
            }
            System.out.println("Case #" + tt + ": " + name);
        }
    }

    public static int solution(String str) {
        int counter = 0;
        int[] carArr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') continue;
            if (++carArr[str.charAt(i) - 'A'] == 1) {
                counter++;
            }
        }
        return counter;
    }
}
