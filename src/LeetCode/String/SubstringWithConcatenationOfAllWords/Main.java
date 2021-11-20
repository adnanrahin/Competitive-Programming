package LeetCode.String.SubstringWithConcatenationOfAllWords;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>(Arrays.asList("word", "good", "best", "word"));

        System.out.println(findSubstring("wordwordgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println(findPiTable("wordwordgoodbestword", set));

    }

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> solution = new ArrayList<>();

        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        Set<Integer> piTableSet = findPiTable(s, wordSet);

        for (Integer piValue : piTableSet) {

            Map<String, Integer> frequency = new HashMap<>();

            Arrays.stream(words).forEach(word -> {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            });

            int count = words.length;
            int j = piValue;
            while (j <= s.length() - words[0].length()) {
                String subString = s.substring(j, j + words[0].length());
                int value = frequency.getOrDefault(subString, 0);
                if (value > 0) {
                    count--;
                    frequency.put(subString, value - 1);
                } else break;
                j += words[0].length();
            }
            if (count == 0) solution.add(piValue);
        }


        return solution;
    }

    public static Set<Integer> findPiTable(String text, Set<String> words) {

        Set<Integer> allPiTable = new HashSet<>();

        for (String pattern : words) {
            String str = pattern + "#" + text;
            int[] piTable = new int[str.length() + 1];
            int i = 0, j = 1;

            while (j < str.length()) {
                if (str.charAt(i) == str.charAt(j)) {
                    piTable[j] = i + 1;
                    i++;
                    j++;
                } else if (i == 0) {
                    piTable[j++] = 0;
                } else i = piTable[i - 1];
            }

            for (int l = pattern.length(); l < piTable.length; l++) {
                if (piTable[l] == pattern.length()) {
                    allPiTable.add(l - 2 * pattern.length());
                }
            }

        }
        return allPiTable;
    }

}
