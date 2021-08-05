package search;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch5 {

    public static int binraySearch(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (target <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (arr[lo] == target) return lo;
        return -(lo + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[30];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(50);
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

            System.out.println(binraySearch(arr, 16));
    }
}
