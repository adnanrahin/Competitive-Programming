package LeetCode.Array.MissingFirstPositive;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

    }

    public int firstMissingPositive(int[] nums) {

        int firstPositive = 1;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) return i;
        }

        return firstPositive;
    }

}
