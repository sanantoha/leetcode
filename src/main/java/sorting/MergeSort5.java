package sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSort5 {

    public static void mergeSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) >>> 1;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        int z = 0;
        int[] tmp = new int[hi - lo + 1];

        while (i <= mid && j <= hi) {
            if (arr[i] <= arr[j]) {
                tmp[z++] = arr[i++];
            } else {
                tmp[z++] = arr[j++];
            }
        }

        while (i <= mid) tmp[z++] = arr[i++];
        while (j <= hi) tmp[z++] = arr[j++];

        for (int k = 0; k < tmp.length; k++) {
            arr[lo + k] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[1000000000];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);
        }

//        System.out.println(Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

//        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) throw new RuntimeException("error");
        }

        System.out.println("done");
    }
}
