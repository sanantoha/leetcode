package sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        int[] result = array.clone();
        sort(array, 0, array.length - 1, result);
        return result;
    }

    private static void sort(int[] array, int l, int r, int[] result) {
        if (l >= r) return;
        int mid = (l + r) >>> 1;

        sort(result, l, mid, array);
        sort(result, mid + 1, r, array);
        merge(array, l, mid, r, result);
    }

    private static void merge(int[] array, int l, int mid, int r, int[] result) {
        int i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid && j <= r) {
            if (array[i] <= array[j]) {
                result[k++] = array[i++];
            } else {
                result[k++] = array[j++];
            }
        }

        while (i <= mid) result[k++] = array[i++];
        while (j <= r) result[k++] = array[j++];
    }

    public static void main(String[] args) {
        int[] arr = {8,3,6,8,3,1,5,7,8,9};

        System.out.println(Arrays.toString(mergeSort(arr)));


        System.out.println("=========================");
        Random rand = new Random();
        int[] arr1 = new int[30];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rand.nextInt(30);
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(mergeSort(arr1)));
    }
}
