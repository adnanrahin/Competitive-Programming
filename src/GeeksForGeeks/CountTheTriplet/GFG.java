package GeeksForGeeks.CountTheTriplet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GFG {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        while (testCase-- > 0) {
            int size = scanner.nextInt();
            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(TwoPointerSolution.countTheTriplet(nums));
        }
    }

    public static class TwoPointerSolution {

        public static int countTheTriplet(int[] nums) {
            int triplet = 0;
            Arrays.sort(nums);
            for (int i = nums.length - 1; i >= 0; i--) {
                int target = nums[i];
                int left = 0;
                int right = i - 1;
                while (left < right) {
                    if (nums[right] + nums[left] == target) {
                        triplet++;
                        left++;
                        right--;
                    } else if (nums[right] + nums[left] > target) right--;
                    else left++;
                }
            }
            return triplet == 0 ? -1 : triplet;
        }
    }

    public static class HasMapSolution {
        public static int countTheTriplet(int[] nums) {
            int triplet = 0;

            Map<Integer, Integer> map;

            for (int i = 0; i < nums.length; i++) {
                int target = nums[i];
                map = new HashMap<>();
                for (int j = 0; j < nums.length; j++) {
                    if (j == i) continue;
                    if (map.containsKey(target - nums[j])) triplet++;
                    map.put(nums[j], j);
                }
            }
            return triplet == 0 ? -1 : triplet;
        }
    }

}
