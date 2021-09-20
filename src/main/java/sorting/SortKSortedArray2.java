package sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray2 {

    // O(n * log(k)) time | O(k) space
    public static int[] sortKSortedArray(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) return arr;

        PriorityQueue<Integer> queue = new PriorityQueue<>(k + 1);
        for (int i = 0; i < Math.min(k + 1, arr.length); i++) {
            queue.add(arr[i]);
        }

        int idx = 0;
        for (int i = k + 1; i < arr.length; i++) {
            int minVal = queue.remove();
            arr[idx++] = minVal;
            queue.add(arr[i]);
        }

        while (!queue.isEmpty()) {
            arr[idx++] = queue.remove();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4, 7, 6, 5};

        System.out.println(Arrays.toString(sortKSortedArray(arr, 3)));
    }
}
