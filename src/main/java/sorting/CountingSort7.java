package sorting;

import java.util.Arrays;
import java.util.Random;

public class CountingSort7 {

    // O(n) time | O(k) space - where k unique elements
    public static void countingSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int minVal = arr[0];
        int maxVal = arr[0];

        for (int i = 1; i < arr.length; i++) {
            minVal = Math.min(minVal, arr[i]);
            maxVal = Math.max(maxVal, arr[i]);
        }

        int[] cnt = new int[maxVal - minVal + 1];
        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i] - minVal]++;
        }

        int idx = 0;
        for (int i = 0; i < cnt.length; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                arr[idx++] = i + minVal;
            }
        }
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
