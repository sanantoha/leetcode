package sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertSort5 {

    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (val > arr[j]) break;
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = val;
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        insertSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
