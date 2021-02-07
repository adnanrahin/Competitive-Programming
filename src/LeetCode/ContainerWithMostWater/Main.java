package LeetCode.ContainerWithMostWater;

public class Main {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;

        while(left < right){
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            maxArea = Math.max(maxArea, h * w);
            if(height[left] > height[right])right--;
            else left--;
        }

        return maxArea;
    }

}
