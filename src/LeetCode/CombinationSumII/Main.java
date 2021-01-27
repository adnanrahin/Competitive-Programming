package LeetCode.CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));

    }
}

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if (candidates.length == 0) return new ArrayList<>();

        List<List<Integer>> solution = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, new ArrayList<>(), solution, 0);

        return solution;
    }

    public void backtrack(int[] candidates, int target, List<Integer> list, List<List<Integer>> solution, int start) {
        if (target < 0) return;
        if (target == 0) {
            solution.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) continue;
            else {
                list.add(candidates[i]);
                backtrack(candidates, target - candidates[i], list, solution, i);
                list.remove(list.size() - 1);
            }
        }

    }
}
