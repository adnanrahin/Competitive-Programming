package HackerRank.Graph.RoadsInHackerLand;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    public static void main(String[] args) throws IOException {

        /*FastReader fr = new FastReader();

        int testCase = fr.nextInt();

        for (int i = 0; i < testCase; i++) {
            int vertex = fr.nextInt();
            int edge = fr.nextInt();
            int[][] roads = new int[edge][3];

            for (int j = 0; j < edge; j++) {
                roads[i][0] = fr.nextInt();
                roads[i][1] = fr.nextInt();
                roads[i][2] = fr.nextInt();
            }
            System.out.println(roadsInHackerland(vertex, roads));
        }*/

        int[][] graph = new int[][]{{1, 3, 5}, {4, 5, 0}, {2, 1, 3}, {3, 2, 1}, {4, 3, 4}, {4, 2, 2}};

        System.out.println(roadsInHackerland(5, graph));

    }

    public static String roadsInHackerland(int n, int[][] roads) {

        int minCost = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        int[] dsu = new int[n + 1];
        for (int i = 1; i <= n; i++) dsu[i] = i;

        for (int[] dir : roads) {
            pq.add(new int[]{dir[0], dir[1], dir[2]});
        }

        while (!pq.isEmpty()) {
            int[] parent = pq.poll();
            int x = find(dsu, parent[0]);
            int y = find(dsu, parent[1]);
            if (x != y) {
                union(dsu, x, y);
                minCost += parent[2];
            }
        }

        System.out.println(minCost);

        return Integer.toBinaryString(minCost);
    }

    public static int find(int[] dsu, int x) {
        if (x == dsu[x]) return x;
        return find(dsu, dsu[x]);
    }

    public static void union(int[] dsu, int x, int y) {
        int xp = find(dsu, x);
        int yp = find(dsu, y);
        dsu[yp] = xp;
    }

}
