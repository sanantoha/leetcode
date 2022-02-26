package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort10 {

    private static Random rand = new Random();

    // O(n*log(n)) time | O(1) space
    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = l + rand.nextInt(r - l + 1);
        swap(arr, pivot, r);
        int j = l;
        for (int i = l; i < r; i++) {
            if (arr[i] <= arr[r]) {
                swap(arr, i, j++);
            }
        }
        swap(arr, j, r);
        return j;
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

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
