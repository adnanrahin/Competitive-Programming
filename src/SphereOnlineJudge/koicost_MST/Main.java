package SphereOnlineJudge.koicost_MST;

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
        int vertex = fr.nextInt();
        int edge = fr.nextInt();

        int[][] graph = new int[edge][3];
        for (int i = 0; i < edge; i++) {
            graph[i][0] = fr.nextInt();
            graph[i][1] = fr.nextInt();
            graph[i][2] = fr.nextInt();
        }
    }

    public static void minimumSpanningTree(int[][] graph, int vertex, int edge) {

    }


}
