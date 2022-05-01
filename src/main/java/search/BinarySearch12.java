package search;

import java.util.Arrays;

public class BinarySearch12 {

    // O(log(n)) time | O(1) space
    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (target == arr[mid]) return mid;
            if (target > arr[mid]) l = mid + 1;
            else r = mid - 1;
        }
        return -(l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        System.out.println(binarySearch(arr, 20));
        System.out.println(Arrays.binarySearch(arr, 20));
    }
}
