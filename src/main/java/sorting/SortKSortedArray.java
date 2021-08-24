package sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://www.algoexpert.io/questions/Sort%20K-Sorted%20Array
 */
public class SortKSortedArray {

    // O(N * log(k)) time | O(k) space
    public static int[] sortKSortedArray(int[] array, int k) {
        int idx = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < Math.min(k + 1, array.length); i++) heap.add(array[i]);

        for (int i = k + 1; i < array.length; i++) {
            int minVal = heap.remove();
            array[idx++] = minVal;

            heap.add(array[i]);
        }

        while (!heap.isEmpty()) {
            array[idx++] = heap.remove();
        }

        return array;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4, 7, 6, 5};

        System.out.println(Arrays.toString(sortKSortedArray(arr, 3)));
    }
}
