package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange1 {

    public static int[] largestRange(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        Arrays.sort(arr);

        int start = arr[0];
        int end = arr[0];
        int currStart = arr[0];
        int longestRange = 0;
        int currRange = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + 1 == arr[i]) {
                currRange++;
            } else {
                currRange = 1;
                currStart = arr[i];
            }

            if (currRange > longestRange) {
                longestRange = currRange;
                start = currStart;
                end = arr[i];
            }
        }

        return new int[] {start, end};
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

            map.put(num, false);
            int currRange = 1;

            int l = num - 1;
            while (map.containsKey(l)) {
                map.put(l, true);
                currRange++;
                l--;
            }

            int r = num + 1;
            while (map.containsKey(r)) {
                map.put(r, true);
                currRange++;
                r++;
            }

            if (currRange > longestRange) {
                longestRange = currRange;
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
