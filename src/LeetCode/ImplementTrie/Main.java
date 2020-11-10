package LeetCode.ImplementTrie;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }

    public class Trie {

        /**
         * Initialize your data structure here.
         */

        public class TrieNode {
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

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode newNode = current.map.get(word.charAt(i));
                if (newNode == null) {
                    newNode = new TrieNode();
                    current.map.put(word.charAt(i), newNode);
                }
                current = newNode;
            }
            current.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode current = root;

            for (int i = 0; i < word.length(); i++) {
                TrieNode newNode = current.map.get(word.charAt(i));
                if (newNode == null) return false;
                else current = newNode;
            }
            return current.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode current = root;

            for (int i = 0; i < prefix.length(); i++) {
                TrieNode newNode = current.map.get(prefix.charAt(i));
                if (newNode == null) return false;
                else current = newNode;
            }
            return true;
        }
    }
}
