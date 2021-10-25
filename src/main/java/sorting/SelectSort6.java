package sorting;

import java.util.Arrays;
import java.util.Random;

public class SelectSort6 {

    public static void selectSort(int[] arr) {

    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        selectSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
