package array;

import java.util.Arrays;

public class SubarraySort5 {

    // O(n) time | O(1) space
    public static int[] subarraySort(int[] array) {
        if (array == null || array.length <= 1) return new int[] {-1, -1};

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (isOutOfOrder(array, i, array[i])) {
                minVal = Math.min(minVal, array[i]);
                maxVal = Math.max(maxVal, array[i]);
            }
        }

        if (minVal == Integer.MAX_VALUE) return new int[] {-1, -1};
        int l = 0;
        while (l < array.length && array[l] <= minVal) l++;
        int r = array.length - 1;
        while (r >= 0 && array[r] >= maxVal) r--;
        return new int[] {l, r};
    }

    private static boolean isOutOfOrder(int[] array, int i, int val) {
        if (i == 0) return val > array[i + 1];
        if (i == array.length - 1) return val < array[i - 1];
        return array[i - 1] > val || val > array[i + 1];
    }

    public static void main(String[] args) {
        var output = subarraySort(new int[] {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
        System.out.println(Arrays.toString(output)); // [3, 9]

        var output1 = subarraySort(new int[] {1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19});
        System.out.println(Arrays.toString(output1)); // [4, 9]

        var output2 = subarraySort(new int[] {1, 2});
        System.out.println(Arrays.toString(output2)); // [-1, -1]
    }
}
