package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-pivot-index/
 *
 * Given an array of integers nums, calculate the pivot index of this array.
 *
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 *
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 *
 * Return the leftmost pivot index. If no such index exists, return -1.
 */
public class FindPivotIndex {

    // O(n) time | O(1) space
    public static int pivotIndex(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int leftSum = 0;
        int rightSum = Arrays.stream(arr).sum();

        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(arr) == 3);

        System.out.println(pivotIndex(new int[] {1, 2, 3}) == -1);

        System.out.println(pivotIndex(new int[] {2, 1, -1}) == 0);
    }
}
