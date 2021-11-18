package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf8 {

    // O(n) time | O(n) space
    public static int[] product(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        int[] res = new int[arr.length];
        Arrays.fill(res, 1);

        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] * arr[i - 1];
        }

        int prev = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] *= prev;
            prev *= arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4};

        System.out.println(Arrays.toString(product(arr)));
    }
}
