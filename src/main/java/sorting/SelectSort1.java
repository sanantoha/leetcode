package sorting;

import java.util.Arrays;
import java.util.Random;

public class SelectSort1 {

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) min = j;
            }
            swap(arr, i, min);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[30];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        selectSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
