package search;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch4 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(binarySearch(arr, 10));
    }

    private static int binarySearch(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < key) {
                lo = mid + 1;
            } else if (arr[mid] > key) {
                hi = mid - 1;
            } else return mid;
        }
        return -1;
    }
}
