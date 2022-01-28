package sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertSort {

    // Best time: O(n) time | O(1) space
    // Avg: O(n ^ 2) time | O(1) space
    // Worst: O(n ^ 2) time | O(1) space
    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] <= value) break;
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = value;
        }
    }

    // O(n ^ 2) time | O(1) space
    public static void insertSort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        insertSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
