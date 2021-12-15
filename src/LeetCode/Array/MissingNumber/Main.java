package LeetCode.Array.MissingNumber;

public class Main {

    public static void main(String[] args) {

    }

    public static int missingNumber(int[] nums) {

        int number = 0, sum = 0, arrSum = 0;

        for (int i = 1; i <= nums.length; i++) {
            sum += i;
            arrSum += nums[i - 1];
        }

        return sum - arrSum;
    }

}
