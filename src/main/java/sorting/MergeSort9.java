package sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSort9 {

    // O(n * log(n)) time | O(n) space
    public static int[] mergeSort(int[] arr) {
        int[] res = arr.clone();
        mergeSort(arr, 0, arr.length - 1, res);
        return res;
    }

    private static void mergeSort(int[] arr, int l, int r, int[] res) {
        if (l >= r) return;

        int mid = (l + r) >>> 1;
        mergeSort(res, l, mid, arr);
        mergeSort(res, mid + 1, r, arr);
        merge(arr, l, mid, r, res);
    }

    private static void merge(int[] arr, int l, int mid, int r, int[] res) {
        int i = l;
        int j = mid + 1;
        int idx = l;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                res[idx++] = arr[i++];
            } else {
                res[idx++] = arr[j++];
            }
        }
        while (i <= mid) res[idx++] = arr[i++];
        while (j <= r) res[idx++] = arr[j++];
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
