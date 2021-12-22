package sorting;

import java.util.Arrays;
import java.util.Random;

public class CountingSort6 {

    // O(n) time | O(d) - where d unique values
    public static void countingSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int minVal = arr[0];
        int maxVal = arr[0];

        for (int num : arr) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        int[] cs = new int[maxVal - minVal + 1];
        for (int num : arr) {
            cs[num - minVal]++;
        }

        int idx = 0;
        for (int i = 0; i < cs.length; i++) {
            for (int j = 0; j < cs[i]; j++) {
                arr[idx++] = i + minVal;
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
