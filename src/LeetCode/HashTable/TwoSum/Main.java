package LeetCode.HashTable.TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3, 2, 4}, 6)));

    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {

                int diff = target - nums[i];

                if (map.containsKey(diff)) {
                    return new int[]{i, map.get(diff)};
                }
                map.put(nums[i], i);

            }

            return new int[]{};
        }
    }

}
