package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange7 {

    // O(n * log(n)) time | O(1) space
    public static int[] largestRange(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        Arrays.sort(arr);

        int startLargestRangeVal = arr[0];
        int startRange = arr[0];
        int endLargestRangeVal = arr[0];
        int largest = 0;
        int currRange = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                currRange++;
            } else {
                currRange = 0;
                startRange = arr[i];
            }

            if (currRange > largest) {
                largest = currRange;
                startLargestRangeVal = startRange;
                endLargestRangeVal = arr[i];
            }
        }

        return new int[] {startLargestRangeVal, endLargestRangeVal};
    }

    // O(n) time | O(n) space
    public static int[] largestRange1(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        Map<Integer, Boolean> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, true);
        }

        int[] largestRange = new int[] {};
        int largestLength = 0;

        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            if (!map.get(num)) continue;

            int length = 1;
            int l = num - 1;
            while (map.containsKey(l)) {
                map.put(l, false);
                length++;
                l--;
            }
            int r = num + 1;
            while (map.containsKey(r)) {
                map.put(r, false);
                length++;
                r++;
            }

            if (largestLength < length) {
                largestLength = length;
                largestRange = new int[] {l + 1, r - 1};
            }
        }

        return largestRange;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};

        System.out.println(Arrays.toString(largestRange(arr))); // [0, 7]

        System.out.println(Arrays.toString(largestRange1(arr))); // [0, 7]
    }
}
