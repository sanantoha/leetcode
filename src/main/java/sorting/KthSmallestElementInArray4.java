package sorting;

import java.util.Random;

public class KthSmallestElementInArray4 {

    private static Random rand = new Random();

    public static int kthSmallestElement(int[] arr, int k) {
        return kthSmallestElement(arr, 0, arr.length - 1, k);
    }

    private static int kthSmallestElement(int[] arr, int l, int r, int k) {
        if (l > r) return Integer.MAX_VALUE;

        int p = partition(arr, l, r);
        if (k - 1 == p) return arr[p];
        if (k - 1 < p) return kthSmallestElement(arr, l, p - 1, k);
        return kthSmallestElement(arr, p + 1, r, k);
    }

    private static int partition(int[] arr, int l, int r) {
        int p = arr[l + rand.nextInt(r - l + 1)];
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

        System.out.println(kthSmallestElement(arr, 9));
    }
}
