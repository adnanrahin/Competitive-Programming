package HackerRank.Array.NewYearChaos;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});

    }


    static void minimumBribes(int[] nums) {

        int counter = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) temp++;
            }
            if (temp > 2) {
                System.out.println("Too chaotic");
                return;
            } else counter += temp;
        }

        System.out.println(counter);

    }

}
