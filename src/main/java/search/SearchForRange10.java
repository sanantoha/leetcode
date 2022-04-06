package search;

import java.util.Arrays;

public class SearchForRange10 {

    public static int[] searchRange(int[] arr, int target) {
        return null;
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
