package sorting;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {

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

    private static void siftDown(int[] arr, int idx, int size) {

        int currIdx = idx;
        while (currIdx <= size) {
            int l = left(currIdx);
            int r = right(currIdx);
            int maxIdx = currIdx;
            if (l <= size && arr[l] > arr[maxIdx]) {
                maxIdx = l;
            }
            if (r <= size && arr[r] > arr[maxIdx]) {
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

    private static void buildHeap(int[] arr, int size) {
        for (int i = size / 2; 0 >= i; i--) {
            siftDown(arr, i, size);
        }
    }

    // O(n * log(n)) time | O(1) time
    public static void heapSort(int[] arr) {
        int size = arr.length - 1;

        buildHeap(arr, size);

        while(size > 0) {
            swap(arr, 0, size);
            size--;
            siftDown(arr, 0, size);
        }
    }


    public static void main(String[] args) {
        int[] arr = {8,3,6,8,3,1,5,7,8,9};

        heapSort(arr);

        System.out.println(Arrays.toString(arr));


        System.out.println("=========================");
        Random rand = new Random();
        int[] arr1 = new int[30];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rand.nextInt(30);
        }

        System.out.println(Arrays.toString(arr1));
        heapSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
