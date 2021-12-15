package LeetCode.String.ImplementStrStr;

public class Main {

    public static void main(String[] args) {

    }

    public static int strStr(String haystack, String needle) {

        int index = -1;

        int[] piTable = getKmpArray(haystack, needle);

        for (int i = needle.length(); i < piTable.length; i++) {
            if (piTable[i] == needle.length()) {
                return i - 2 * needle.length();
            }
        }

        return index;
    }

    public static int[] getKmpArray(String text, String pattern) {

        String str = pattern + "#" + text;
        int[] pi = new int[str.length()];
        int i = 0, j = 1;

        while (j < pi.length) {
            if (str.charAt(i) == str.charAt(j)) {
                pi[j] = i + 1;
                i++;
                j++;
            } else if (i == 0) {
                pi[j] = 0;
                j++;
            } else {
                i = pi[i - 1];
            }
        }

        return pi;
    }

}
