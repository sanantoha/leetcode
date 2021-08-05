package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort3 {

    private static Random rand = new Random();

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int q = partition(arr, lo, hi);
        quickSort(arr, lo, q - 1);
        quickSort(arr, q + 1, hi);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int partition(int[] arr, int lo, int hi) {
        swap(arr, hi, lo + rand.nextInt(hi - lo + 1));
        int pivot = arr[hi];
        int j = lo;
        for (int i = lo; i < hi; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, j++);
            }
        }
        swap(arr, j, hi);
        return j;
    }

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
}
