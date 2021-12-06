package LeetCode.Array.MergeSortedArray;

public class Main {

    public static void main(String[] args) {

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] solution = new int[m + n];

        int i = 0, j = 0, index = 0;

        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                solution[index] = nums2[j++];
                solution[++index] = nums1[i++];
                index++;
            } else if (nums1[i] > nums2[j]) {
                solution[index] = nums2[j++];
                index++;
            } else {
                solution[index] = nums1[i++];
                index++;
            }
        }

        if (i == m) {
            while (j < n) {
                solution[index] = nums2[j++];
                index++;
            }
        } else if (j == n) {
            while (i < m) {
                solution[index] = nums1[i++];
                index++;
            }
        }

        System.arraycopy(solution, 0, nums1, 0, solution.length);

    }

}
