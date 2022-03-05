package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange4 {

    // O(n * log(n)) time | O(1) space
    public static int[] largestRange(int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];

        Arrays.sort(arr);

        int largestRangeLength = 0;
        int startValue = arr[0];
        int currStartValue = arr[0];
        int endValue = arr[0];
        int currentRangeLength = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) continue;
            int prev = arr[i - 1];
            int curr = arr[i];
            if (prev + 1 == curr) {
                currentRangeLength++;
            } else {
                currStartValue = curr;
                currentRangeLength = 1;
            }
            if (largestRangeLength < currentRangeLength) {
                largestRangeLength = currentRangeLength;
                startValue = currStartValue;
                endValue = curr;
            }
        }

        return new int[] {startValue, endValue};
    }

    // O(n) time | O(n) space
    public static int[] largestRange1(int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];

        Map<Integer, Boolean> map = new HashMap<>();
        for (int v : arr) {
            map.put(v, true);
        }

        int longestRangeLength = 0;
        int[] range = new int[0];

        for (int curr : arr) {
            if (!map.get(curr)) continue;

            int currentRangeLength = 1;

            int l = curr - 1;
            while (map.containsKey(l)) {
                map.put(l, false);
                l--;
                currentRangeLength++;
            }
            int r = curr + 1;
            while (map.containsKey(r)) {
                map.put(r, false);
                r++;
                currentRangeLength++;
            }

            if (longestRangeLength < currentRangeLength) {
                longestRangeLength = currentRangeLength;
                range = new int[]{l + 1, r - 1};
            }
        }


        return range;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};

        System.out.println(Arrays.toString(largestRange(arr))); // [0, 7]

        System.out.println(Arrays.toString(largestRange1(arr))); // [0, 7]
    }
}
