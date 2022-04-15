package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf2 {

    // O(n) time | O(n) space
    public static int[] product(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        int[] res = new int[arr.length];

        int leftPrev = 1;

        for (int i = 0; i < arr.length; i++) {
            res[i] = leftPrev;
            leftPrev *= arr[i];
        }

        int rightPrev = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] *= rightPrev;
            rightPrev *= arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4};

        System.out.println(Arrays.toString(product(arr)));
    }
}
