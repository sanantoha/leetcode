package search;

import java.util.Arrays;

public class SearchForRange {

    public static int[] searchRange(int[] arr, int target) {
        if (arr == null || arr.length == 0) return new int[]{-1, -1};

        int lo = leftSearch(arr, target);
        if (lo == -1) return new int[]{-1, -1};
        int hi = rightSearch(arr, lo, target);
        return new int[] {lo, hi};
    }

    private static int leftSearch(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return arr[lo] == target ? lo : -1;
    }

    private static int rightSearch(int[] arr, int lo, int target) {
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = ((lo + hi) >>> 1) + 1;
            if (arr[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }

        return hi;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,8,8,8,8,10};
        System.out.println(Arrays.toString(searchRange(arr, 8)));

        System.out.println(Arrays.toString(searchRange(arr, 6)));

        int[] arr1 = {1};

        System.out.println(Arrays.toString(searchRange(arr1, 1)));

        int[] arr2 = {};

        System.out.println(Arrays.toString(searchRange(arr2, 0)));
    }
}
