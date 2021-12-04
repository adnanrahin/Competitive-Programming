package LeetCode.Array.SearchInsertPosition;

public class Main {

    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {

        int left = 0, right = nums.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

}
