package sorting;

import java.util.Random;

public class KthSmallestElementInArray9 {

    private static Random rand = new Random();

    // O(n) time | O(log(n)) space
    public static int kthSmallestElement(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 0) return Integer.MIN_VALUE;


        return kthSmallestElement(arr, 0, arr.length - 1, k);
    }

    private static int kthSmallestElement(int[] arr, int l, int r, int k) {
        if (l > r) return Integer.MIN_VALUE;

        int p = partition(arr, l, r);

        if (k == p + 1) return arr[p];
        if (k > p + 1) return kthSmallestElement(arr, p + 1, r, k);
        return kthSmallestElement(arr, l, p - 1, k);
    }

    private static int partition(int[] arr, int l, int r) {
        int p = l + rand.nextInt(r - l + 1);
        swap(arr, p, r);
        int j = l;
        for (int i = l; i < r; i++) {
            if (arr[i] <= arr[r]) {
                swap(arr, i, j++);
            }
        }
        swap(arr, r, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {8,2,1,6,9,3,45,6,7,13};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(kthSmallestElement(arr, i + 1));
        }

        System.out.println(kthSmallestElement(arr, -1));
        System.out.println(kthSmallestElement(arr, 0));
        System.out.println(kthSmallestElement(arr, 11));
    }
}
