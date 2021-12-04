package LeetCode.Array.MaximumSubArray;

public class Main {

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {

        if (nums.length == 0) return 0;

        int globalMaxSum = nums[0], localMaxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (localMaxSum + nums[i] < nums[i]) {
                localMaxSum = nums[i];
            }
            localMaxSum += nums[i];
            globalMaxSum = Math.max(globalMaxSum, localMaxSum);
        }

        return globalMaxSum;
    }

}
