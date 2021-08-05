package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf1 {

    public static int[] productExceptSelf(int[] arr) {
        if (arr == null || arr.length == 0) return arr;

        int[] result = new int[arr.length];
        result[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            result[i] = arr[i - 1] * result[i - 1];
        }

        int r = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] = result[i] * r;
            r = r * arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
}
