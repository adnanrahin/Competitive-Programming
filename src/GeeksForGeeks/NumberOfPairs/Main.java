package GeeksForGeeks.NumberOfPairs;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(countPairs(new int[]{1, 2, 6}, new int[]{1, 5}, 3, 2));
    }

    public static long countPairs(int[] nums1, int[] nums2, int m, int n) {
        long counter = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;

        while (i < m && j < n) {
            int x = nums1[i];
            int y = nums2[j];
            int xPow = (int) Math.pow(x, y);
            int yPow = (int) Math.pow(y, x);
        }

        return counter;
    }
}
