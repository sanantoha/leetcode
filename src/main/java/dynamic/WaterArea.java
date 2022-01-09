package dynamic;

import java.util.Arrays;

/**
 * https://www.algoexpert.io/questions/Water%20Area
 */
public class WaterArea {

    // O(n) time | O(n) space
    public static int waterArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int[] water = new int[heights.length];

        int leftMax = 0;
        for (int i = 0; i < heights.length; i++) {
            water[i] = leftMax;
            leftMax = Math.max(leftMax, heights[i]);
        }

        int rightMax = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            int minHeight = Math.min(water[i], rightMax);
            if (minHeight > heights[i]) {
                water[i] = minHeight - heights[i];
            } else {
                water[i] = 0;
            }
            rightMax = Math.max(rightMax, heights[i]);
        }

        return Arrays.stream(water).sum();
    }

    // O(n) time | O(1) space
    public static int waterArea1(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int l = 0;
        int r = heights.length - 1;
        int leftMax = heights[l];
        int rightMax = heights[r];
        int surfaceArea = 0;

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
