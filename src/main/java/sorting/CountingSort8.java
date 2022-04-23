package sorting;

import java.util.Arrays;
import java.util.Random;

public class CountingSort8 {

    // O(n) time | O(k) space - where k unique elements
    public static void countingSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int num : arr) {
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
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
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(50);
        }

        System.out.println(Arrays.toString(arr));

        countingSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
