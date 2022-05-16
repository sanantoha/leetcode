package search;

import java.util.Arrays;

public class SearchForRange {

    // O(log(n)) time | O(1) space
    public static int[] searchRange(int[] arr, int target) {
        if (arr == null || arr.length == 0) return new int[] {};

        int l = leftBinarySearch(arr, target);
        if (l == -1) return new int[] {};
        int r = rightBinarySearch(arr, l, target);
        return new int[] {l, r};
    }

    private static int rightBinarySearch(int[] arr, int l, int target) {
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (target >= arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private static int leftBinarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (target <= arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (arr[l] == target) ? l : -1;
    }

    public static void main(String[] args) {
        int[] arr = {5,6, 7,7,8,8,8,8,8,8,8,10};
        System.out.println(Arrays.toString(searchRange(arr, 8)));

        System.out.println(Arrays.toString(searchRange(arr, 6)));

        int[] arr1 = {1};

        System.out.println(Arrays.toString(searchRange(arr1, 1)));

        int[] arr2 = {};

        System.out.println(Arrays.toString(searchRange(arr2, 0)));
    }
}
