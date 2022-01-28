package sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertSort2 {

    // O(n ^ 2) time | O(1) space
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] <= val) break;
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = val;
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
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(30);
        }

        System.out.println(Arrays.toString(arr));

        insertSort1(arr);

        System.out.println(Arrays.toString(arr));
    }
}
