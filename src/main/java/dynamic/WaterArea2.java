package dynamic;

import java.util.Arrays;

public class WaterArea2 {

    // O(n) time | O(n) space
    public static int waterArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int[] maximum = new int[heights.length];
        int leftMax = 0;

        for (int i = 0; i < heights.length; i++) {
            maximum[i] = leftMax;
            leftMax = Math.max(heights[i], leftMax);
        }

        int rightMax = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            int minHeight = Math.min(maximum[i], rightMax);
            if (minHeight > heights[i]) {
                maximum[i] = minHeight - heights[i];
            } else maximum[i] = 0;
            rightMax = Math.max(rightMax, heights[i]);
        }

        return Arrays.stream(maximum).sum();
    }

    // O(n) time | O(1) space
    public static int waterArea1(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int l = 0;
        int r = heights.length - 1;

        int leftMax = heights[l];
        int rightMax = heights[r];

        int sumArea = 0;

        while (l < r) {
            if (heights[l] < heights[r]) {
                l++;
                leftMax = Math.max(leftMax, heights[l]);
                sumArea += leftMax - heights[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, heights[r]);
                sumArea += rightMax - heights[r];
            }
        }
        return sumArea;
    }

    public static void main(String[] args) {
        int[] input = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        int actual = waterArea(input);
        System.out.println(actual);
        System.out.println(actual == 48);

        actual = waterArea1(input);
        System.out.println(actual);
        System.out.println(actual == 48);
    }
}
