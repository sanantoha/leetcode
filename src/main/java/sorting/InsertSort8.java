package sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertSort8 {

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int v = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (arr[j] < v) break;
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = v;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(30);
        }

        System.out.println(Arrays.toString(arr));

        insertSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
