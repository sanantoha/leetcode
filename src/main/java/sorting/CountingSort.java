package sorting;

import java.util.Arrays;
import java.util.Random;

public class CountingSort {

    private static void countingSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int min = arr[0];
        int max = arr[0];

        for (int value : arr) {
            if (value > max) max = value;
            if (value < min) min = value;
        }

        int[] cs = new int[max - min + 1];

        for (int value : arr) {
            cs[value - min]++;
        }

        int ind = 0;
        for (int i = 0; i < cs.length; i++) {
            for (int j = 0; j < cs[i]; j++) {
                arr[ind++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(50);
        }

        System.out.println(Arrays.toString(arr));

        countingSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
