package sorting;

import java.util.Arrays;

public class KthSmallestElementInArray2 {

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pv = arr[hi];
        int j = lo;
        for (int i = lo; i < hi; i++) {
            if (arr[i] <= pv) {
                swap(arr, i, j++);
            }
        }
        swap(arr, j, hi);
        return j;
    }

    private static int kthSmallestElem(int[] arr, int lo, int hi, int target) {
        if (lo > hi) return Integer.MAX_VALUE;

        int p = partition(arr, lo, hi);

        if (p == target - 1) return arr[p];

        if (p > target - 1) return kthSmallestElem(arr, lo, p - 1, target);
        else return kthSmallestElem(arr, p + 1, hi, target);
    }

    public static int kthSmallestElem(int[] arr, int target) {
        return kthSmallestElem(arr, 0, arr.length - 1, target);
    }

    public static void main(String[] args) {
        int[] arr = {8,32,9,23,6,8,0,1,2,5};

//        System.out.println(kthSmallestElem(arr, 3));

        for (int i = 0; i < arr.length; i++) {
            System.out.println(kthSmallestElem(arr, i + 1));
        }

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
