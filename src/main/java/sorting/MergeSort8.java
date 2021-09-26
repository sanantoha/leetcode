package sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSort8 {

    public static int[] mergeSort(int[] arr) {
        int[] result = arr.clone();
        mergeSort(arr, 0, arr.length - 1, result);
        return result;
    }

    private static void mergeSort(int[] arr, int l, int r, int[] result) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(result, l, mid, arr);
        mergeSort(result, mid + 1, r, arr);
        merge(arr, l, mid, r, result);
    }

    private static void merge(int[] arr, int l, int mid, int r, int[] result) {
        int i = l;
        int j = mid + 1;
        int idx = l;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                result[idx++] = arr[i++];
            } else {
                result[idx++] = arr[j++];
            }
        }

        while (i <= mid) result[idx++] = arr[i++];
        while (j <= r) result[idx++] = arr[j++];
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
