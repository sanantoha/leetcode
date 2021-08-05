package array;

import java.util.Arrays;

public class LargestRange {

    public static int[] largestRange(int[] array) {
        return new int[] {};
    }

    public static void main(String[] args) {
        // 1st solution sort array
        // 2nd use hashmap
        // check https://www.algoexpert.io/questions/Largest%20Range

        int[] arr = new int[] {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};

        System.out.println(Arrays.toString(largestRange(arr))); // [0, 7]
    }
}
