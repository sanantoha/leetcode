package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange5 {

    // O(n * log(n)) time | O(1) space
    public static int[] largestRange(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        Arrays.sort(arr);

        int startRange = arr[0];
        int currRangeLength = 0;
        int maxRangeLength = 0;
        int maxStartRange = startRange;
        int maxEndRange = arr[0];


        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) continue;
            if (arr[i - 1] + 1 == arr[i]) {
                currRangeLength++;
            } else {
                currRangeLength = 1;
                startRange = arr[i];
            }
            if (maxRangeLength < currRangeLength) {
                maxRangeLength = currRangeLength;
                maxStartRange = startRange;
                maxEndRange = arr[i];
            }
        }

        return new int[] {maxStartRange, maxEndRange};
    }

    // O(n) time | O(n) space
    public static int[] largestRange1(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, true);
        }

        int maxLength = 0;
        int[] bestRange = new int[2];

        for (int num : arr) {
            if (!map.get(num)) continue;

            int currLength = 1;
            int l = num - 1;
            while (map.containsKey(l)) {
                map.put(l, false);
                currLength++;
                l--;
            }

            int r = num + 1;
            while (map.containsKey(r)) {
                map.put(r, false);
                currLength++;
                r++;
            }

            if (maxLength < currLength) {
                maxLength = currLength;
                bestRange = new int[] {arr[l + 1], arr[r - 1]};
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
