package LeetCode.String.LongestPalindromicSubstring;

public class Main {

    public static void main(String[] args) {

    }

    public static String longestPalindrome(String s) {

        int end = 0, start = 0;

        for (int i = 0; i < s.length(); i++) {
            int oddLen = getLen(s, i, i);
            int evenLen = getLen(s, i, i + 1);
            int len = Math.max(oddLen, evenLen);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + (len / 2);
            }
        }

        return s.substring(start, end + 1);
    }

    public static int getLen(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
