package sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertSort10 {

    // Worst: O(n ^ 2) time | O(1) space
    // Avg: O(n ^ 2) time | O(1) space
    // Best: O(n) time | O(1) space
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] < val) break;
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = val;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        insertSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
