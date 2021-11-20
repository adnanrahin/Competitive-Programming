package LeetCode.PirorityQueue.TopKFrequentElements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (Integer key : freq.keySet()) {
            int ocr = freq.get(key);
            if (priorityQueue.size() == k) {
                if (priorityQueue.peek()[1] < ocr) {
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{key, ocr});
                }
            } else priorityQueue.add(new int[]{key, ocr});
        }

        int[] solution = new int[priorityQueue.size()];

        int i = 0;
        while (!priorityQueue.isEmpty()) {
            solution[i++] = priorityQueue.poll()[0];
        }

        return solution;
    }
}
