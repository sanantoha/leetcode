package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf1 {

    // O(n) time | O(n) space
    public static int[] product(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        int[] product = new int[arr.length];

        int prevLeft = 1;
        for (int i = 0; i < arr.length; i++) {
            product[i] = prevLeft;
            prevLeft *= arr[i];
        }

        int prevRight = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            product[i] *= prevRight;
            prevRight *= arr[i];
        }


        return product;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4};

        System.out.println(Arrays.toString(product(arr)));
    }
}
