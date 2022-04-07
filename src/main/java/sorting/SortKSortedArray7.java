package sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray7 {

    // O(n * log(k)) time | O(k) space
    public static int[] sortKSortedArray(int[] arr, int k) {
        if (arr == null || arr.length == 0) return new int[] {};

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < Math.min(arr.length, k + 1); i++) {
            pq.add(arr[i]);
        }

        int idx = 0;
        int[] res = new int[arr.length];
        for (int i = k + 1; i < arr.length; i++) {
            res[idx++] = pq.remove();

            pq.add(arr[i]);
        }

        while (!pq.isEmpty()) {
            res[idx++] = pq.remove();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4, 7, 6, 5};

        System.out.println(Arrays.toString(sortKSortedArray(arr, 3)));
    }
}
