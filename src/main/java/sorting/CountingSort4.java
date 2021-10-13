package sorting;

import java.util.Arrays;
import java.util.Random;

public class CountingSort4 {

    // O(n) time | O(d) space - where d is unique values
    public static void countingSort(int[] arr) {

        int minV = Integer.MAX_VALUE;
        int maxV = Integer.MIN_VALUE;
        for (int v : arr) {
            minV = Math.min(minV, v);
            maxV = Math.max(maxV, v);
        }

        int[] cs = new int[maxV - minV + 1];
        for (int v : arr) {
            cs[v - minV]++;
        }

        int idx = 0;
        for (int i = 0; i < cs.length; i++) {
            for (int j = 0; j < cs[i]; j++) {
                arr[idx++] = i + minV;
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
