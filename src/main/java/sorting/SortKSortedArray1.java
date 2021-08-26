package sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray1 {

    public static int[] sortKSortedArray(int[] arr, int k) {
        if (arr == null || arr.length == 0) return arr;

        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);

        for (int i = 0; i < Math.min(k + 1, arr.length); i++) {
            heap.add(arr[i]);
        }

        int idx = 0;
        for (int i = k + 1; i < arr.length; i++) {
            int min = heap.remove();
            arr[idx++] = min;

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
