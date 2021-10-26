package sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSort10 {

    public static int[] mergeSort(int[] arr) {
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

//        mergeSort(arr, 0, arr.length - 1);
        arr = mergeSort(arr);

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) throw new RuntimeException("error");
        }

        System.out.println("done");
    }
}
