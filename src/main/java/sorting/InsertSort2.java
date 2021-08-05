package sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertSort2 {

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] < value) break;
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = value;
        }
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
