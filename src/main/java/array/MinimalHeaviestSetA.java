package array;

import java.util.Arrays;

/**
 * This task from hakerrunk
 * split give array on two arrays where second one has sum with bigger than sum first one,
 *
 * input:
 *  [6, 4, 2, 3, 1, 5]
 * output:
 *      [5, 6] - it should be sorted 5 + 6 > 1 + 2 + 3 + 4, because 11 > 10, length of output is has minimum
 *     length, which sum higher that other elements in array
 *
 *
 */
public class MinimalHeaviestSetA {

    // O(n * log(n)) time | O(1) space
    private static int[] minimalHeaviestSetA(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        Arrays.sort(arr);

        int l = 0;
        int r = arr.length - 1;

        int leftSum = arr[l];
        int rightSum = arr[r];

        while (l < r) {
            if (rightSum > leftSum) {
                l++;
                leftSum += arr[l];
            } else {
                r--;
                rightSum += arr[r];
            }
        }
        System.out.println(l + " " + r);
        int[] res = new int[arr.length - r];
        System.arraycopy(arr, r, res, 0, res.length);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 3, 1, 5};

        System.out.println(Arrays.toString(minimalHeaviestSetA(arr))); // [5, 6]
    }
}
