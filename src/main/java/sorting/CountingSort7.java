package sorting;

import java.util.Arrays;
import java.util.Random;

public class CountingSort7 {

    public static void countingSort(int[] arr) {

    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(50);
        }

        System.out.println(Arrays.toString(arr));

        countingSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
