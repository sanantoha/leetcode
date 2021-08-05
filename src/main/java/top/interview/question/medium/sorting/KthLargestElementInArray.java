package top.interview.question.medium.sorting;

import java.util.Arrays;

class Solution2 {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int j = lo;
        for (int i = lo; i < hi; i++) {
            if (arr[i] > pivot) {
                swap(arr, i, j++);
            }
        }
        swap(arr, j, hi);
        return j;
    }

    public int findKthLargest(int[] arr, int lo, int hi, int k) {
        if (lo > hi) return Integer.MAX_VALUE;

        int p = partition(arr, lo, hi);
        if (p == k - 1) return arr[p];
        if (p > k - 1) return findKthLargest(arr, lo, p - 1, k);

        return findKthLargest(arr, p + 1, hi, k);
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }
}

public class KthLargestElementInArray {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        int[] arr = {3,2,1,5,6,4};

        System.out.println(s.findKthLargest(arr, 2));
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {3,2,3,1,2,4,5,5,6};

        System.out.println(s.findKthLargest(arr1, 4));
        System.out.println(Arrays.toString(arr1));
    }
}
