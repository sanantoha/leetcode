package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private final static Random rand = new Random();

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int partition(int[] arr, int lo, int hi) {
        swap(arr, rand.nextInt(hi - lo + 1) + lo, hi);

        int j = lo;
        for (int i = lo; i < hi; i++) {
            if (arr[i] <= arr[hi]) {
                swap(arr, j, i);
                j++;
            }
        }
        swap(arr, j, hi);
        return j;
    }

    // O(n * log(n)) time | O(log(n)) space
    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int q = partition(arr, lo, hi);
        quickSort(arr, lo, q - 1);
        quickSort(arr, q + 1, hi);
    }

    public static void main(String[] args) {
        int[] arr = {8,3,6,8,3,1,5,7,8,9};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));


        System.out.println("=========================");
        Random rand = new Random();
        int[] arr1 = new int[30];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rand.nextInt(30);
        }

        System.out.println(Arrays.toString(arr1));
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }
}
