package array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductOfArrayExceptSelf7 {

    // O(n) time | O(n) space
    public static int[] product(int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];

        int[] res = new int[arr.length];
        res[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] * arr[i - 1];
        }

        int prev = 1;
        for (int j = arr.length - 1; j >= 0; j--) {
            res[j] = res[j] * prev;
            prev *= arr[j];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4};

        System.out.println(Arrays.toString(product(arr)));
    }
}
