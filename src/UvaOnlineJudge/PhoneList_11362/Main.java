package UvaOnlineJudge.PhoneList_11362;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        FastReader fr = new FastReader();

        int testCase = fr.nextInt();

        for (int i = 1; i <= testCase; i++) {
            int PhoneListNumbers = fr.nextInt();
            Trie trie = new Trie();
            boolean isConsistent = false;

            List<String> words = new ArrayList<>();

            for (int j = 1; j <= PhoneListNumbers; j++) {
                String word = fr.nextLine();
                if (isConsistent) continue;
                isConsistent = trie.insert(word);
            }

            if (isConsistent) System.out.println("NO");
            else System.out.println("YES");
        }

    }

    public static class Trie {

        public static class TrieNode {
            Map<Character, TrieNode> map;
            boolean isWord;

            public TrieNode() {
                map = new HashMap<>();
                isWord = false;
            }
        }

        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public boolean insert(String word) {
            TrieNode temp = root;
            boolean foundPrefix = false;
            for (int i = 0; i < word.length(); i++) {
                TrieNode newNode = temp.map.get(word.charAt(i));
                if (newNode == null) {
                    newNode = new TrieNode();
                    temp.map.put(word.charAt(i), newNode);
                } else if (newNode != null) {
                    foundPrefix = newNode.isWord;
                }
                temp = newNode;
            }
            temp.isWord = true;

            return foundPrefix;
        }

    }

}
