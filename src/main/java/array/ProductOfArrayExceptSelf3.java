package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf3 {

    private static int[] productOfArrayExceptSelf(int[] arr) {
        if (arr == null || arr.length == 0) return arr;

        int[] result = new int[arr.length];

        result[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            result[i] = result[i - 1] * arr[i - 1];
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

        System.out.println(Arrays.toString(productOfArrayExceptSelf(arr)));

        int[] arr1 = {1,2,0,4};

        System.out.println(Arrays.toString(productOfArrayExceptSelf(arr1)));

        int[] arr2 = {0,2,0,4};

        System.out.println(Arrays.toString(productOfArrayExceptSelf(arr2)));
    }
}
