package HackerRank.Graph.ConnectedCellInGrid;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

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
        for (int i = 0; i < testCase; i++) {
            int n = fr.nextInt();
            int m = fr.nextInt();
            int[][] matrix = new int[n][m];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    matrix[row][col] = fr.nextInt();
                }
            }
        }
    }

    public static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static int maxRegion(int[][] grid) {
        int maxRegion = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    maxRegion = Math.max(maxRegion, breadthFirstSearch(grid, i, j));
            }
        }

        return maxRegion;
    }

    public static int breadthFirstSearch(int[][] grid, int row, int col) {

        int sizeOfCurrentCluster = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        grid[row][col] = 0;

        while (!queue.isEmpty()) {
            int[] parent = queue.poll();
            sizeOfCurrentCluster++;

            for (int[] dir : directions) {
                int r = dir[0] + parent[0];
                int c = dir[1] + parent[1];
                if (isValid(grid, r, c) && grid[r][c] == 1) {
                    queue.add(new int[]{r, c});
                    grid[r][c] = 0;
                }
            }
        }
        return sizeOfCurrentCluster;
    }

    public static boolean isValid(int[][] gird, int row, int col) {
        return row >= 0 && row < gird.length && col >= 0 && col < gird[0].length;
    }

}
