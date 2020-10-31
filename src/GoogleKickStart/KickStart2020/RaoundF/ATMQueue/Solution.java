package GoogleKickStart.KickStart2020.RaoundF.ATMQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
            int customerNumber = fr.nextInt();
            int amount = fr.nextInt();
            int[][] token = new int[customerNumber][2];
            for (int i = 0; i < customerNumber; i++) {
                token[i][0] = i + 1;
                token[i][1] = fr.nextInt();
            }
            solution(tt, token, amount);
        }

    }

    public static void solution(int caseNumber, int[][] token, int amount) {
        List<Integer> solution = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>(Arrays.asList(token));
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            if (arr[1] <= amount) {
                solution.add(arr[0]);
            } else {
                queue.add(new int[]{arr[0], Math.abs(arr[1] - amount)});
            }
        }
        System.out.print("Case #" + caseNumber + ": ");
        for (Integer integer : solution) System.out.print(integer + " ");
        System.out.println();
    }

}
