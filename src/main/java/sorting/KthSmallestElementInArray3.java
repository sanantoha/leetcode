package sorting;

public class KthSmallestElementInArray3 {

    private static int partition(int[] arr, int l, int r) {
        int pv = arr[r];
        int j = l;
        for (int i = l; i < r; i++) {
            if (arr[i] <= pv) {
                swap(arr, i, j++);
            }
        }

        swap(arr, j, r);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int kthSmallestElement(int[] arr, int l, int r, int k) {
        if (l > r) return Integer.MAX_VALUE;

        int p = partition(arr, l, r);
        if (p == k - 1) return arr[p];
        if (p > k - 1) return kthSmallestElement(arr, l, p - 1, k);
        return kthSmallestElement(arr, p + 1, r, k);
    }

    public static int kthSmallestElement(int[] arr, int k) {
        return kthSmallestElement(arr, 0, arr.length - 1, k);
    }

    public static void main(String[] args) {
        int[] arr = {8,2,1,6,9,3,45,6,7,13};

        System.out.println(kthSmallestElement(arr, 0));
    }
}
