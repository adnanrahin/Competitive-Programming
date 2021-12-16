package LeetCode.Array.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums.length < 4) return new ArrayList<>();

        List<List<Integer>> solution = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1, right = nums.length - 1;

                while (left < right) {


                    if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }

                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        solution.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else left++;

                }

            }

        }

        return solution;
    }

}
