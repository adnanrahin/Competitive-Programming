package UvaOnlineJudge.Airports_11733;

import java.io.*;
import java.util.*;

public class Main {

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }

            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }

            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));

            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }

            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(
                    new BufferedWriter(new OutputStreamWriter(outputStream))
            );
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

    static class IOUtils {
        public static int[] readIntArray(InputReader in, int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = in.readInt();
            }
            return array;
        }
    }

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

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

        out.close();

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
