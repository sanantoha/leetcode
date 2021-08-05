package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort4 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivotV = arr[hi];

        int j = lo;
        for (int i = lo; i < hi; i++) {
            if (arr[i] <= pivotV) {
                swap(arr, i, j++);
            }
        }

        swap(arr, j, hi);
        return j;
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo > hi) return;

        int p = partition(arr, lo, hi);
        quickSort(arr, lo, p - 1);
        quickSort(arr, p + 1, hi);
    }
}
