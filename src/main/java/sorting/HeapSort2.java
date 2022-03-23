package sorting;

import java.util.Arrays;
import java.util.Random;

public class HeapSort2 {

    // O(n * log(n)) time | O(1) space
    public static void heapSort(int[] arr) {
        int size = arr.length - 1;
        buildHeap(arr, size);

        while (size > 0) {
            swap(arr, size, 0);
            size--;
            heapify(arr, 0, size);
        }
    }

    private static void buildHeap(int[] arr, int size) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i, size);
        }
    }

    private static void heapify(int[] arr, int idx, int size) {

        int currIdx = idx;

        while (true) {
            int l = left(currIdx);
            int r = right(currIdx);
            int maxIdx = currIdx;

            if (l <= size && arr[maxIdx] < arr[l]) {
                maxIdx = l;
            }

            if (r <= size && arr[maxIdx] < arr[r]) {
                maxIdx = r;
            }
            if (maxIdx != currIdx) {
                swap(arr, maxIdx, currIdx);
                currIdx = maxIdx;
            } else {
                break;
            }
        }
    }

    private static int left(int i) {
        return i * 2 + 1;
    }

    private static int right(int i) {
        return i * 2 + 2;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
