package LeetCode.SlidingWindow.TrappingRainWater;

public class Main {

    public static void main(String[] args) {

        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));

    }

    public static int trap(int[] height) {

        int result = 0;

        int[] left = new int[height.length], right = new int[height.length];

        left[0] = height[0];
        right[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            result += Math.min(right[i], left[i]) - height[i];
        }

        return result;
    }

}
