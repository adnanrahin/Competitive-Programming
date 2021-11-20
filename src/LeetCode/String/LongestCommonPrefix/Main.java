package LeetCode.String.LongestCommonPrefix;

public class Main {

    public static void main(String[] args) {

        System.out.println(new Solution().smallestLengthString(new String[]{"flower", "flight", "flow"}));

    }

    static class Solution {

        public String longestCommonPrefix(String[] strs) {

            String longestCommonPrefix = "";
            String smallestString = smallestLengthString(strs);

            for (int i = 0; i < smallestString.length(); i++) {
                char ch = smallestString.charAt(i);
                for (int j = 0; j < strs.length; j++) {
                    if (strs[j].charAt(i) != ch) return longestCommonPrefix;
                }
                longestCommonPrefix += ch;
            }

            return longestCommonPrefix;
        }

        public String smallestLengthString(String[] strs) {
            int smallestLen = strs[0].length();
            String sol = strs[0];

            for (int i = 1; i < strs.length; i++) {
                if (smallestLen > strs[i].length()) {
                    sol = strs[i];
                    smallestLen = strs[i].length();
                }
            }

            return sol;
        }

    }

}
