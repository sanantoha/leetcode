package sorting;

public class KthSmallestElementInArray1 {

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int j = lo;
        for (int i = lo; i < hi; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, j++);
            }
        }
        swap(arr, j, hi);
        return j;
    }

    private static int findKthSmallestRec(int[] arr, int lo, int hi, int k) {
        if (lo > hi) return Integer.MAX_VALUE;

        int p = partition(arr, lo, hi);
        if (p == k - 1) return arr[p];

        if (p > k - 1) return findKthSmallestRec(arr, lo, p - 1, k);

        return findKthSmallestRec(arr, p + 1, hi, k);
    }

    public static int findKthSmallest(int[] arr, int k) {
        return findKthSmallestRec(arr, 0, arr.length - 1, k);
    }

    public static void main(String[] args) {
        int[] arr = {9,8,1,5,2,6,0,3,4};

        System.out.println(findKthSmallest(arr, 5));
    }
}
