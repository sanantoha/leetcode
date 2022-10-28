package array;

import java.util.Arrays;

/**
 * https://www.algoexpert.io/questions/Subarray%20Sort
 */
public class SubarraySort {

    // O(n) time | O(1) space
    public static int[] subarraySort(int[] array) {
        if (array == null || array.length <= 1) return new int[] {-1, -1};

        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (isOutOfBound(i, array)) {
                minOutOfOrder = Math.min(minOutOfOrder, array[i]);
                maxOutOfOrder = Math.max(maxOutOfOrder, array[i]);
            }
        }

        if (minOutOfOrder == Integer.MAX_VALUE) return new int[] {-1, -1};

        int lidx = 0;
        while (minOutOfOrder >= array[lidx]) {
            lidx++;
        }

        int ridx = array.length - 1;
        while (maxOutOfOrder <= array[ridx]) {
            ridx--;
        }

        return new int[] {lidx, ridx};
    }

    private static boolean isOutOfBound(int i, int[] array) {
        int num = array[i];
        if (i == 0) return num > array[i + 1];
        else if (i == array.length - 1) return num < array[i - 1];
        else return num > array[i + 1] || num < array[i - 1];
    }

    public static void main(String[] args) {
        var output = subarraySort(new int[] {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
        System.out.println(Arrays.toString(output)); // [3, 9]

        var output1 = subarraySort(new int[] {1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19});
        System.out.println(Arrays.toString(output1)); // [4, 9]

        var output2 = subarraySort(new int[] {1, 2});
        System.out.println(output2); // [-1, -1]
    }
}
