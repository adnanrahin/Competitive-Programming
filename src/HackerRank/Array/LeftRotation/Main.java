package HackerRank.Array.LeftRotation;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {/*
        System.out.println(Arrays.toString(rotLeft(new int[]{41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51}, 10)));*/
        System.out.println(Arrays.toString(rotLeft(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2)));
    }

    public static int[] rotLeft(int[] a, int d) {
        int[] dp = new int[d];

        d %= a.length;

        for (int i = 0; i < d; i++) {
            dp[i] = a[i];
        }

        for (int i = d, j = 0; i < a.length; j++, i++) {
            a[j] = a[i];
        }

        for (int i = a.length - d, j = 0; i < a.length; j++, i++) {
            a[i] = dp[j];
        }
        return a;
    }

}
