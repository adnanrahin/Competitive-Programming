package LeetCode.Array.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


    }

    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) return new ArrayList<>();

        List<List<Integer>> solution = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int leftPtr = i + 1, rightPtr = nums.length - 1;
            while (leftPtr < rightPtr) {

                if (rightPtr < nums.length - 1 && nums[rightPtr] == nums[rightPtr + 1]) {
                    rightPtr--;
                    continue;
                }
                int sum = nums[i] + nums[leftPtr] + nums[rightPtr];

                if (sum == 0) {
                    solution.add(Arrays.asList(nums[i], nums[leftPtr], nums[rightPtr]));
                    leftPtr++;
                    rightPtr--;
                } else if (sum > 0) {
                    rightPtr--;
                } else leftPtr++;
            }
        }

        return solution;
    }

}
