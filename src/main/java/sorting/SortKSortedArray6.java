package sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray6 {

    // O(n * log(k)) time | O(k) space
    public static int[] sortKSortedArray(int[] arr, int k) {
        if (arr == null || arr.length == 0) return new int[] {};

        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);
        for (int i = 0; i < Math.min(k + 1, arr.length); i++) {
            heap.add(arr[i]);
        }

        int idx = 0;
        for (int i = k + 1; i < arr.length; i++) {
            arr[idx++] = heap.remove();

            heap.add(arr[i]);
        }

        while (!heap.isEmpty()) {
            arr[idx++] = heap.remove();
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4, 7, 6, 5};

        System.out.println(Arrays.toString(sortKSortedArray(arr, 3)));
    }
}
