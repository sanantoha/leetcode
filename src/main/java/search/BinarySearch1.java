package search;

import java.util.Arrays;

public class BinarySearch1 {
    
    public static int binarySearch(int[] arr, int target) {
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        System.out.println(binarySearch(arr, 21));
        System.out.println(Arrays.binarySearch(arr, 21));
    }
}
