package LeetCode.Array.TwoSumII;

public class Main {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else left++;
        }

        return new int[]{};
    }

}
