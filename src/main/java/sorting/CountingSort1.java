package sorting;

import java.util.Arrays;
import java.util.Random;

public class CountingSort1 {

    public static void countingSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int min = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) min = arr[i];
            if (max < arr[i]) max = arr[i];
        }

        int[] cs = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            cs[arr[i] - min]++;
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
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(50);
        }

        System.out.println(Arrays.toString(arr));

        countingSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
