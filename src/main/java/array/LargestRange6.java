package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange6 {

    // O(n * log(n)) time | O(1) space
    public static int[] largestRange(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        Arrays.sort(arr);
        int largestRangeLength = 0;
        int length = 0;
        int start = 0;
        int currStart = arr[0];
        int end = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + 1 == arr[i]) {
                length++;
            } else {
                currStart = arr[i];
                length = 1;
            }

            if (largestRangeLength < length) {
                largestRangeLength = length;
                start = currStart;
                end = arr[i];
            }
        }

        return new int[] {start, end};
    }

    // O(n) time | O(n) space
    public static int[] largestRange1(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        Map<Integer, Boolean> numbers = new HashMap<>();
        for (int num : arr) {
            numbers.put(num, true);
        }

        int[] largestRange = new int[] {};
        int largestRangeLength = 0;

        for (int num : arr) {
            if (!numbers.get(num)) continue;

            int length = 1;
            int l = num - 1;
            while (numbers.containsKey(l)) {
                numbers.put(l, false);
                length++;
                l--;
            }

            int r = num + 1;
            while (numbers.containsKey(r)) {
                numbers.put(r, false);
                length++;
                r++;
            }

            if (largestRangeLength < length) {
                largestRangeLength = length;
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
