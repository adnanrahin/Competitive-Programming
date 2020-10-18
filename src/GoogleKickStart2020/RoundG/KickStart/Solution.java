package GoogleKickStart2020.RoundG.KickStart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

        /*solution("AKICKSTARTPROBLEMNAMEDKICKSTART", 1);
        solution("STARTUNLUCKYKICK", 1);
        solution("KICKXKICKXSTARTXKICKXSTART", 1);*/

        FastReader fr = new FastReader();

        int testCase = fr.nextInt();

        for (int i = 1; i <= testCase; i++) {
            String string = fr.nextLine();
            solution(string, i);
        }
    }

    public static void solution(String str, int caseNumber) {

        int counter = 0;

        List<Integer> kick = piTable(str, "KICK");
        List<Integer> start = piTable(str, "START");

        for (Integer k : kick) {
            for (Integer s : start) {
                if (k < s) counter++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + counter);

    }

    public static List<Integer> piTable(String text, String pattern) {
        String str = pattern + "#" + text;
        int[] pi = new int[str.length()];

        int i = 0, j = 1;

        while (j < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                pi[j] = i + 1;
                i++;
                j++;
            } else {
                if (i > 0) {
                    i = pi[i - 1];
                } else j++;
            }
        }

        List<Integer> index = new ArrayList<>();

        for (int l = pattern.length(); l < str.length(); l++) {
            if (pi[l] == pattern.length()) {
                index.add(l - 2 * pattern.length());
            }
        }
        return index;
    }
}
