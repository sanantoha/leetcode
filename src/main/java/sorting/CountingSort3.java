package sorting;

import java.util.Arrays;
import java.util.Random;

public class CountingSort3 {

    // O(n) time | O(d) space - where d unique values in array
    public static void countingSort(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int v : arr) {
            min = Math.min(min, v);
            max = Math.max(max, v);
        }

        int[] cs = new int[max - min + 1];
        for (int v : arr) {
            cs[v - min]++;
        }

        int idx = 0;
        for (int i = 0; i < cs.length; i++) {
            for (int j = 0; j < cs[i]; j++) {
                arr[idx++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(50);
        }

        System.out.println(Arrays.toString(arr));

        countingSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
