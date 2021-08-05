package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf2 {

    public static int[] productExceptSelf(int[] arr) {
        if (arr == null || arr.length == 0) return arr;

        int[] result = new int[arr.length];
        result[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }

        int r = 1;
        for (int j = arr.length - 1; j >= 0; j--) {
            result[j] = result[j] * r;
            r = r * arr[j];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
}
