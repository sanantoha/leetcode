package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort10 {

    public static void quickSort(int[] arr, int l, int r) {

    }

    public static void main(String[] args) {
        int[] arr = new int[30];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
