package LeetCode.BackTracking.LetterCombinationOfPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println(letterCombinations("23"));

    }

    public static List<String> letterCombinations(String digits) {

        if (digits.length() == 0) return new ArrayList<>();

        Map<Character, String> keys = new HashMap<>();

        keys.put('1', "");
        keys.put('2', "abc");
        keys.put('3', "def");
        keys.put('4', "ghi");
        keys.put('5', "jkl");
        keys.put('6', "mno");
        keys.put('7', "pqrs");
        keys.put('8', "tuv");
        keys.put('9', "wxyz");
        keys.put('0', "");

        List<String> solution = new ArrayList<>();

        backTrack(digits, keys, solution, 0, "");

        return solution;
    }

    public static void backTrack(String digits, Map<Character, String> keys, List<String> solution, int start, String str) {

        if (start == digits.length()) {
            solution.add(str);
            return;
        }

        String key = keys.get(digits.charAt(start));

        for (int i = 0; i < key.length(); i++) {

            str += key.charAt(i);

            backTrack(digits, keys, solution, start + 1, str);

            str = str.substring(0, str.length() - 1);

        }

    }

}
