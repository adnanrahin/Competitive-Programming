package UvaOnlineJudge.PhoneList_11362;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static boolean isConsistent = true;

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

        for (int i = 0; i < testCase; i++) {
            int n = fr.nextInt();
            Trie trie = new Trie();
            isConsistent = true;
            for (int j = 0; j < n; ++j) {
                String digits = fr.nextLine();
                if (isConsistent)
                    trie.buildTree(digits);
            }
            if (isConsistent)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }


    private static class Trie {
        public static class TrieNode {
            boolean isCons;
            Map<Character, TrieNode> next;

            public TrieNode() {
                isCons = false;
                next = new HashMap<>();
            }
        }

        private final TrieNode root;

        private Trie() {
            root = new TrieNode();
        }

        private void buildTree(String s) {

            TrieNode current = root;

            for (int i = 0; i < s.length(); i++) {

                TrieNode newNode = current.next.get(s.charAt(i));

                if (newNode == null) {
                    newNode = new TrieNode();
                    current.next.put(s.charAt(i), newNode);

                } else {
                    if (newNode.isCons || i == s.length() - 1) {
                        isConsistent = false;
                        break;
                    }
                }
                current = newNode;
            }
            current.isCons = true;
        }
    }
}