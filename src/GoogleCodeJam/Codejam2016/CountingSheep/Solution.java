package GoogleCodeJam.Codejam2016.CountingSheep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
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

        FastReader fastReader = new FastReader();

        int testCase = fastReader.nextInt();

        int i = 1;

        while (i <= testCase) {
            int n = fastReader.nextInt();
            solution(i, n);
            i++;
        }

    }

    public static void solution(int caseNumber, int n) {
        if (n == 0) {
            System.out.println("Case #" + caseNumber + ": " + "INSOMNIA");
            return;
        }
        Set<Integer> visitedNumber = new HashSet<>();
        int i = 1;
        int temp = 1;
        while (true) {
            temp = n * i;
            countNumbers(temp, visitedNumber);
            if (isExistAll(visitedNumber)) {
                System.out.println("Case #" + caseNumber + ": " + temp);
                return;
            }
            i++;
        }
    }

    public static boolean isExistAll(Set<Integer> visited) {
        for (int i = 0; i < 10; i++) if (!visited.contains(i)) return false;
        return true;
    }

    public static boolean countNumbers(int number, Set<Integer> visited) {
        boolean temp = false;
        while (number != 0) {
            int mod = number % 10;
            if (visited.add(mod)) {
                temp = true;
            }
            number /= 10;
        }
        return temp;
    }


}
