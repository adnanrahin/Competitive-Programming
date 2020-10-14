package SphereOnlineJudge.MaryBMW_MST;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
        FastReader fr = new FastReader();
        int testCase = fr.nextInt();
        while (testCase-- > 0) {
            long vertex = fr.nextInt();
            long edge = fr.nextInt();
            long[][] graph = new long[(int) edge][3];
            for (int i = 0; i < edge; i++) {
                graph[i][0] = fr.nextInt();
                graph[i][1] = fr.nextInt();
                graph[i][2] = fr.nextInt();
            }
            System.out.println(solution(vertex, graph));
        }
    }

    public static long solution(long vertex, long[][] graph) {

        long[] dsu = new long[(int) vertex + 1];
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[2], a[2]));

        for (long[] e : graph) {
            pq.add(new long[]{e[0], e[1], e[2]});
        }

        for (int i = 1; i <= vertex; i++) dsu[i] = i;

        while (!pq.isEmpty()) {
            long[] parent = pq.poll();
            long x = find(dsu, parent[0]);
            long y = find(dsu, parent[1]);

            if (x != y) {
                union(dsu, x, y);
                if (find(dsu, 1) == find(dsu, vertex)) return parent[2];
            }
        }
        return -1;
    }

    public static long find(long[] dsu, long x) {
        if (dsu[(int) x] == x)
            return x;
        return x = find(dsu, dsu[(int) x]);
    }

    public static void union(long[] dsu, long x, long y) {
        long xP = find(dsu, x);
        long yP = find(dsu, y);
        dsu[(int) yP] = xP;
    }
}
