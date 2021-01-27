package LeetCode.CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7));

    }

}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates.length == 0) return new ArrayList<>();

        List<List<Integer>> solution = new ArrayList<>();

        backtrack(candidates, target, new ArrayList<>(), solution, 0);

        return solution;
    }

    public void backtrack(int[] nums, int target, List<Integer> list, List<List<Integer>> solution, int start) {
        if (target < 0) return;
        if (target == 0) {
            solution.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, target - nums[i], list, solution, i);
            list.remove(list.size() - 1);
        }
    }
}
