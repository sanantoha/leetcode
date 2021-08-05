package sorting;

import java.util.Arrays;
import java.util.Random;
import top.interview.question.medium.design.RandomizedSet;

public class InsertSort6 {

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int v = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] < v) break;
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = v;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[30];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        insertSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
