package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf9 {

    // O(n) time | O(n) space
    public static int[] product(int[] arr) {
        if (arr == null || arr.length == 0) return arr;

        int[] product = new int[arr.length];
        Arrays.fill(product, 1);

        for (int i = 1; i < arr.length; i++) {
            product[i] = product[i - 1] * arr[i - 1];
        }

        int prev = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            product[i] = product[i] * prev;
            prev *= arr[i];
        }

        return product;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4};

        System.out.println(Arrays.toString(product(arr)));
    }
}
