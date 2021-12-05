package LeetCode.BackTracking.Subsets;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(subsets(new int[]{1, 2, 3}));

    }

    static List<List<Integer>> solution;

    public static List<List<Integer>> subsets(int[] nums) {

        solution = new ArrayList<>();

        backTrack(nums, new ArrayList<>(), 0);

        return solution;
    }


    public static void backTrack(int[] nums, List<Integer> list, int start) {

        if (start > nums.length) return;

        solution.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backTrack(nums, list, i + 1);
            list.remove(list.size() - 1);
        }

    }

}
