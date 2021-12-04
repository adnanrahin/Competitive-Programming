package LeetCode.HashTable.GroupAnagrams;

import java.util.*;

public class Main {

    public static void main(String[] args) {

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) return new ArrayList<>();

        List<List<String>> solution = new ArrayList<>();

        Map<String, List<String>> mapTable = new HashMap<>();

        for (String str : strs) {
            String sortedKey = sortString(str);
            if (!mapTable.containsKey(sortedKey)) {
                mapTable.put(sortedKey, new ArrayList<>());
            }
            mapTable.get(sortedKey).add(str);
        }

        for (String str : mapTable.keySet()) {
            solution.add(mapTable.get(str));
        }

        return solution;
    }

    public static String sortString(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }


}
