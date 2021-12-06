package LeetCode.Array.RotateArray;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        rotate(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 3);

    }

    public static void rotate(int[] nums, int k) {

        k = k % nums.length;

        int[] arr = new int[k];

        for (int i = nums.length - k; i < nums.length; i++) {
            arr[i - (nums.length - k)] = nums[i];
        }

        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }

    }

}
