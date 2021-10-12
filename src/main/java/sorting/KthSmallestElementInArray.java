package sorting;

import java.util.Arrays;

public class KthSmallestElementInArray {
    public static void main(String[] args) {
        int[] arr = new int[] {5,9,2,6,0,6,4,8,1};



        System.out.println(findKthSmallest(arr, 1));
        System.out.println(findKthSmallest(arr, 2));
        System.out.println(findKthSmallest(arr, 3));
        System.out.println(findKthSmallest(arr, 4));
        System.out.println(findKthSmallest(arr, 5));
        System.out.println(findKthSmallest(arr, 6));
        System.out.println(findKthSmallest(arr, 7));
        System.out.println(findKthSmallest(arr, 8));
        System.out.println(findKthSmallest(arr, 9));

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Best, Average: O(n) time | O(log(n)) space
    // Worst: O(n ^ 2) time | O(log(n)) space
    public static int findKthSmallest(int[] arr, int k) {
        return findKthSmallestRec(arr, 0, arr.length - 1, k);
    }

    public static int findKthSmallestRec(int[] arr, int lo, int hi, int k) {
        if (lo > hi) return Integer.MAX_VALUE;

        int p = partition(arr, lo, hi);
        if (p == k - 1) return arr[p];
        if (p > k - 1) return findKthSmallestRec(arr, lo, p - 1, k);

        return findKthSmallestRec(arr, p + 1, hi, k);
    }

    private static int partition(int[] arr, int lo, int hi) {

        int j = lo;
        for (int i = lo; i < hi; i++) {
            if (arr[i] <= arr[hi]) {
                swap(arr, i, j++);
            }
        }

        swap(arr, j, hi);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
