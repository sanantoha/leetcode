package sorting;

import java.util.Arrays;
import java.util.Random;

public class HeapSort3 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int left(int i) {
        return i * 2 + 1;
    }

    private static int right(int i) {
        return i * 2 + 2;
    }

    private static void siftDown(int[] arr, int i, int size) {
        int l = left(i);
        int r = right(i);

        int maxInd = i;
        if (l <= size && arr[maxInd] < arr[l]) {
            maxInd = l;
        }
        if (r <= size && arr[maxInd] < arr[r]) {
            maxInd = r;
        }

        if (maxInd != i) {
            swap(arr, maxInd, i);
            siftDown(arr, maxInd, size);
        }
    }

    private static void buildHeap(int[] arr, int size) {
        for (int i = arr.length / 2; i >= 0; i--) {
            siftDown(arr, i, size);
        }
    }

    private static void heapSort(int[] arr) {
        int size = arr.length - 1;

        buildHeap(arr, size);

        while (size > 0) {
            swap(arr, 0, size);
            size--;
            siftDown(arr, 0, size);
        }
    }
}
