package UvaOnlineJudge.Airports_11733;

import java.io.*;
import java.util.*;

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

        Scanner fr = new Scanner(System.in);

        int testCase = fr.nextInt();

        for (int i = 1; i <= testCase; i++) {
            int vertex = fr.nextInt();
            int edge = fr.nextInt();
            int cost = fr.nextInt();
            int[][] roads = new int[edge][3];
            for (int j = 0; j < edge; j++) {
                roads[j][0] = fr.nextInt();
                roads[j][1] = fr.nextInt();
                roads[j][2] = fr.nextInt();
            }
            kruskal(vertex, roads, cost, i);
        }

    }

    public static void kruskal(int vertex, int[][] roads, int cost, int caseNumber) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        int minCost = 0;
        int numberOfPath = vertex;

        int[] dsu = new int[vertex + 1];
        for (int i = 1; i <= vertex; i++) dsu[i] = i;

        for (int i = 0; i < roads.length; i++) {
            pq.add(new int[]{roads[i][0], roads[i][1], roads[i][2]});
        }

        while (!pq.isEmpty()) {
            int[] parent = pq.poll();
            if (parent[2] >= cost) break;
            int x = find(dsu, parent[0]);
            int y = find(dsu, parent[1]);
            if (x != y) {
                union(dsu, parent[0], parent[1]);
                minCost += parent[2];
                if (--numberOfPath == 1) break;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + (minCost + numberOfPath * cost) + " " + numberOfPath);
    }

    public static int find(int[] dsu, int x) {
        if (x == dsu[x]) return x;
        return find(dsu, dsu[x]);
    }

    public static void union(int[] dsu, int x, int y) {
        dsu[find(dsu, y)] = find(dsu, x);
    }

}
