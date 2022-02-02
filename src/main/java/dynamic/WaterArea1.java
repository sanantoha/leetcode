package dynamic;

import java.util.Arrays;

/**
 * https://www.algoexpert.io/questions/Water%20Area
 */
public class WaterArea1 {

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
            int minHeight = Math.min(maxes[i], rightMax);
            maxes[i] = (minHeight > heights[i]) ? minHeight - heights[i] : 0;
            rightMax = Math.max(rightMax, heights[i]);
        }

        return Arrays.stream(maxes).sum();
    }

    // O(n) time | O(1) space
    public static int waterArea1(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int surfaceArea = 0;
        int l = 0;
        int r = heights.length - 1;

        int leftMax = heights[l];
        int rightMax = heights[r];

        while (l < r) {
            if (heights[l] < heights[r]) {
                l++;
                leftMax = Math.max(leftMax, heights[l]);
                surfaceArea += leftMax - heights[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, heights[r]);
                surfaceArea += rightMax - heights[r];
            }
        }

        return surfaceArea;
    }

    public static void main(String[] args) {
        int[] input = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        System.out.println(waterArea(input) == 48);

        System.out.println(waterArea1(input) == 48);
    }
}
