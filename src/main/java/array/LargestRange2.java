package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange2 {


    public static int[] largestRange(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        Arrays.sort(arr);

        int startVal = arr[0];
        int endVal = arr[0];
        int currentStartVal = arr[0];

        int longestRange = 0;
        int currentRange = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + 1 == arr[i]) {
                currentRange++;
            } else {
                currentStartVal = arr[i];
                currentRange = 1;
            }

            if (longestRange < currentRange) {
                longestRange = currentRange;
                startVal = currentStartVal;
                endVal = arr[i];
            }
        }

        return new int[] {startVal, endVal};
    }

    public static int[] largestRange1(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        Map<Integer, Boolean> map = new HashMap<>();

        for (int v : arr) {
            map.put(v, true);
        }
        int longestRange = 0;
        int[] bestRange = null;
        for (int num : arr) {
            if (!map.get(num)) continue;

            int currentRange = 1;
            int l = num - 1;
            while (map.containsKey(l)) {
                map.put(l, false);
                currentRange++;
                l--;
            }
            int r = num + 1;
            while (map.containsKey(r)) {
                map.put(r, false);
                currentRange++;
                r++;
            }
            if (currentRange > longestRange) {
                longestRange = currentRange;
                bestRange = new int[] {l + 1, r - 1};
            }
        }

        return bestRange;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};

        System.out.println(Arrays.toString(largestRange(arr))); // [0, 7]

        System.out.println(Arrays.toString(largestRange1(arr))); // [0, 7]
    }
}
