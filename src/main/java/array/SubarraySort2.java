package array;

import java.util.Arrays;

public class SubarraySort2 {

    // O(n) time | O(1) space
    public static int[] subarraySort(int[] array) {
        if (array == null || array.length == 0) return new int[] {-1, -1};

        int minOutOfBound = Integer.MAX_VALUE;
        int maxOutOfBound = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (isOutOfBound(array, i)) {
                minOutOfBound = Math.min(minOutOfBound, array[i]);
                maxOutOfBound = Math.max(maxOutOfBound, array[i]);
            }
        }

        if (minOutOfBound == Integer.MAX_VALUE) return new int[] {-1, -1};

        int l = 0;
        while (minOutOfBound >= array[l]) l++;

        int r = array.length - 1;
        while (maxOutOfBound <= array[r]) r--;

        return new int[] {l, r};
    }

    private static boolean isOutOfBound(int[] array, int i) {
        if (i == 0) return array[i] > array[i + 1];
        else if (i == array.length - 1) return array[i] < array[i - 1];
        else return array[i] > array[i + 1] || array[i - 1] > array[i];
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
