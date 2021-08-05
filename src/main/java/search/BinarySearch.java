package search;


import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    public static int search(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return arr[l] == target ? l : -(l + 1);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 2;
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(search(arr, 15));
    }
}
