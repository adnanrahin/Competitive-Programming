package LeetCode.KthLargestElementInAnArray;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

    }


}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int kThLargestElement = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (pq.size() == k) {
                if (pq.peek() < nums[i]) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            } else {
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }
}