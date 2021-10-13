package search;


import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    // O(log(n)) time | O(1) space
    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (target > arr[mid]) {
                l = mid + 1;
            } else if (target < arr[mid]) {
                r = mid - 1;
            } else {
                return mid;
            }
        }

        return -(l + 1);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 2;
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(binarySearch(arr, 15));


        int[] arr1 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        System.out.println(binarySearch(arr1, 80));
    }
}
