package dynamic;

import java.util.Arrays;

public class WaterArea3 {

    // O(n) time | O(n) space
    public static int waterArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int[] maximum = new int[heights.length];

        int leftMax = 0;

        for (int i = 0; i < heights.length; i++) {
            maximum[i] = leftMax;
            leftMax = Math.max(leftMax, heights[i]);
        }

        int rightMax = 0;

        for (int i = heights.length - 1; i >= 0; i--) {
            int minHeight = Math.min(maximum[i], rightMax);
            if (minHeight - heights[i] > 0) {
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

        int areaSum = 0;

        while (l < r) {
            if (heights[l] < heights[r]) {
                l++;
                leftMax = Math.max(leftMax, heights[l]);
                areaSum += leftMax - heights[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, heights[r]);
                areaSum += rightMax - heights[r];
            }
        }

        return areaSum;
    }

    public static void main(String[] args) {
        int[] input = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        System.out.println(waterArea(input) == 48);
        System.out.println(waterArea1(input) == 48);
    }
}
