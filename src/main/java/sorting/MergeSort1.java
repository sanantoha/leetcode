package sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSort1 {

    public static void mergeSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int q = (lo + hi) >>> 1;
        mergeSort(arr, lo, q);
        mergeSort(arr, q + 1, hi);
        merge(arr, lo, q, hi);
    }

    public static void merge(int[] arr, int lo, int q, int hi) {
        int[] tmp = new int[hi - lo + 1];
        int i = lo;
        int j = q + 1;
        int k = 0;
        while (i <= q && j <= hi) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        while(i <= q) tmp[k++] = arr[i++];
        while(j <= hi) tmp[k++] = arr[j++];

        for (int z = 0; z < tmp.length; z++) {
            arr[lo + z] = tmp[z];
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,3,6,8,3,1,5,7,8,9};

        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));


        System.out.println("=========================");
        Random rand = new Random();
        int[] arr1 = new int[30];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rand.nextInt(30);
        }

        System.out.println(Arrays.toString(arr1));
        mergeSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }
}
