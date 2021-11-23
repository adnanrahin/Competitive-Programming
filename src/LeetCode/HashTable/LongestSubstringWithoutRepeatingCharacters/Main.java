package LeetCode.HashTable.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String s) {

        int local = 0, global = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {
                local = Math.max(local, map.get(s.charAt(i)));
            }

            map.put(s.charAt(i), i + 1);

            global = Math.max(i + 1 - local, global);

        }

        return global;
    }

}
