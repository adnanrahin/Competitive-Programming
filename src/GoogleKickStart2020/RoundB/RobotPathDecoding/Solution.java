package GoogleKickStart2020.RoundB.RobotPathDecoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
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

        /*solution("SSSEEE", 1);
        solution("N", 1);
        solution("N3(S)N2(E)N", 1);
        solution("2(3(NW)2(W2(EE)W))", 1);*/

        FastReader fr = new FastReader();

        int testCase = fr.nextInt();

        for (int i = 1; i <= testCase; i++) {
            String direction = fr.nextLine();
            solution(direction, i);
        }
    }

    public static String decodeString(String s) {
        StringBuilder str = new StringBuilder();
        Stack<String> strings = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
        int num = 0;

        for (int i = 0; i < s.length(); i++) {

            if (Character.isLetter(s.charAt(i))) {
                str.append(s.charAt(i));
            } else if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == '(') {
                strings.push(str.toString());
                numbers.push(num);
                num = 0;
                str = new StringBuilder();
            } else {
                int rpt = numbers.pop();
                str = new StringBuilder(((strings.isEmpty()) ? "" : strings.pop()) + str.toString().repeat(Math.max(0, rpt)));
            }
        }
        return str.toString();
    }

    public static void solution(String word, int testCase) {

        String str = decodeString(word);

        Map<Character, Integer> map = new HashMap<>();

        map.put('N', -1);
        map.put('E', +1);
        map.put('S', +1);
        map.put('W', -1);

        long x = 1, y = 1;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (Character.isLetter(ch)) {
                if (ch == 'N' || ch == 'S') {
                    y += map.get(ch);
                    if (y == 0) y = 1000000000;
                    else if (y > 1000000000) y = 1;
                } else if (ch == 'E' || ch == 'W') {
                    x += map.get(ch);
                    if (x == 0) x = 1000000000;
                    else if (x > 1000000000) x = 1;
                }
            }
        }

        System.out.println("Case #" + testCase + ": " + x + " " + y);
    }
}
