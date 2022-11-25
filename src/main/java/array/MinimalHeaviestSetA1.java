package array;

import java.util.Arrays;

/**
 * This task from hakerrunk
 * split give array on two arrays where second one has sum with bigger than sum first one,
 *
 * input:
 *  [6, 4, 2, 4, 1, 5]
 * output:
 *      [5, 6] - it should be sorted 5 + 6 > 1 + 2 + 3 + 4, because 11 > 10, length of output is has minimum
 *     length, which sum higher that other elements in array
 *
 *
 */
public class MinimalHeaviestSetA1 {

    private static int[] minimalHeaviestSetA(int[] arr) {
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 3, 1, 5};

        System.out.println(Arrays.toString(minimalHeaviestSetA(arr))); // [5, 6]
    }
}
