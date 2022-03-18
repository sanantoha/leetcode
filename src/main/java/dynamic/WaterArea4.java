package dynamic;

import java.util.Arrays;

public class WaterArea4 {

    // O(n) time | O(n) space
    public static int waterArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int[] maxes = new int[heights.length];

        int leftMax = 0;

        for (int i = 0; i < heights.length; i++) {
            maxes[i] = leftMax;
            leftMax = Math.max(leftMax, heights[i]);
        }

        int rightMax = 0;

        for (int i = heights.length - 1; i >= 0; i--) {
            int minHeight = Math.min(rightMax, maxes[i]);
            int water = minHeight - heights[i];
            if (water > 0) {
                maxes[i] = water;
            } else maxes[i] = 0;
            rightMax = Math.max(rightMax, heights[i]);
        }

        return Arrays.stream(maxes).sum();
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
        System.out.println(waterArea(input) == 48);

        System.out.println(waterArea1(input) == 48);
    }
}
